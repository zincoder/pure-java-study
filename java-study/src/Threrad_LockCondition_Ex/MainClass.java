package Threrad_LockCondition_Ex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Toilet {
	public int paper;
	
	public Toilet() {
		this.paper = 5;
	}
	
	public void setPaper(int paper) {
		this.paper = paper;
	}
	
	public int getPaper() {
		return paper;
	}
	
	public void usePaper() {
		this.paper--;
	}
}

class Cleaner implements Runnable {
	private Toilet toilet;
	
	private ReentrantLock lock;
	private Condition forCleaner;
	private Condition forPerson;
	
	public Cleaner(Toilet toilet, ReentrantLock lock, Condition forCleaner, Condition forPerson) {
		this.toilet = toilet;
		this.lock = lock;
		this.forCleaner = forCleaner;
		this.forPerson = forPerson;
	}
	
	public void replacePaper(int p) {
		toilet.setPaper(p);
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		while(true) {
			//화장실은 혼자만 사용가능
			//여러 쓰레드가 접근하지 못함
			//잠겨있다면 lock을 잡을때까지 잠시 대기
			lock.lock();
			try {
				//휴지를 충전할 필요가 없다면 하지 않음
				if(toilet.getPaper() <= 0) {
					System.out.println(name + " replaces toilet paper.");
					replacePaper(5);
					//다른 사람들에게 화장실이 사용 가능함을 알려줌
					System.out.println("Finish Wake everybody");
					forPerson.signalAll();
				}
				
				try {
					//아직 휴지가 충분하면 바로 화장실을 나와서 자신의 대기실로 이동
					System.out.println(name + " Go to wait");
					forCleaner.await();
					Thread.sleep(500);
					System.out.println(name+" wakes.");
				} catch(Exception e) {
					e.printStackTrace();
				}
			} 
			finally {
				lock.unlock();
			}
		}
	}
	
}

class User implements Runnable {
	private Toilet toilet;
	
	private ReentrantLock lock;
	private Condition forCleaner;
	private Condition forPerson;
	
	//사용해야하는 화장실을 지정
	//lock, lock을 위한 Condition 인스턴스 생성
	public User(Toilet toilet, ReentrantLock lock, Condition forCleaner, Condition forPerson) {
		this.toilet = toilet;
		this.lock = lock;
		this.forCleaner = forCleaner;
		this.forPerson = forPerson;
	}
	
	//화장실의 휴지가 있는지 확인
	public boolean checkToilet() {
		return toilet.getPaper() >= 1;
	}
	
	public void usePaper() {
		//휴지 하나 사용 후 나머지 휴지
		toilet.usePaper();
	}
	
	public void run() {
		String name = Thread.currentThread().getName();
		while(true) {
			//화장실은 한사람만 사용 가능
			lock.lock();
			try {
				//화장실에 휴지가 있는지 확인
				//휴지가 없으면 계속 대기
				while(toilet.getPaper() < 1) {
					System.out.println(name + " is waiting for rreplacing papaer.");
					
					try {
						//대기 중인 청소부 소환
						forCleaner.signal();
						//휴지가 없으므로 대기 pool로 이동
						forPerson.await();
						Thread.sleep(5000);
						System.out.println(name + " wakes");
					} catch(Exception e) {
						e.printStackTrace();
						
					}
				}
				
				//화장실 볼 일을 보고 휴지를 사용 후 화장실 사용을 종료
				System.out.println(name + " uses toilet.");
				usePaper();
				try {
					//휴지가 없으면 다른 사람을 위해 청소부에게 알림
					if(toilet.getPaper() <= 0) {
						forCleaner.signal();
					}
					// 자신은 화장실을 나감
					forPerson.await();
					Thread.sleep(500);
				} catch(Exception e) {
					
				}
			} finally {
				lock.unlock();
			}
		}
	}
	
	
	
}

public class MainClass {
	private static Toilet toilet = new Toilet();
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition forCleaner = lock.newCondition();
	private static Condition forPerson = lock.newCondition();
	
	public static void main(String[] args) {
		//관리하는 화장실을 지정
		Cleaner cleaner = new Cleaner(toilet, lock, forCleaner, forPerson);
		Thread cleanerThread = new Thread(cleaner, "cleaner");
		cleanerThread.start();
		
		User[] user = new User[5];
		for(int i=0; i<user.length; i++) {
			//사람객체생성. 이사람이 사용해야하는 화장실도 지정
			user[i] = new User(toilet, lock, forCleaner, forPerson);
			Thread th = new Thread(user[i],"Person-" + i);
			//사람 객체를 행동시키는 쓰레드를 실행
			 th.start();
		}
	}
}