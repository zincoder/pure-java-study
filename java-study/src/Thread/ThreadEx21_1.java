package Thread;

public class ThreadEx21_1 {
	public static void main(String args[]) {
		RunnableEx21_1 r = new RunnableEx21_1();
		new Thread(r).start(); //Thread그룹에 의하 참조므로 gc대상이 아님
		new Thread(r).start(); //Thread그룹에 의하 참조므로 gc대상이 아님
	}

}

class Account21_1 {
	private int balance = 100;
	public int getBalance() {
		return balance;
	}
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				balance -= money;
			}
		}
	}
}
class RunnableEx21_1 implements Runnable{
	Account21_1 acc = new Account21_1();
	
	public void run() {
		while(acc.getBalance() > 0) {
			//100, 200, 300중의 한 값을 임의로 선택해서 출금
			int money = (int)(Math.random() * 3 + 1)*100;
			acc.withdraw(money);
			System.out.println("balance:"+acc.getBalance());
		}
	}
}