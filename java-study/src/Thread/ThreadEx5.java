package Thread;

public class ThreadEx5 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		
		ThreadEx5_1 t1 = new ThreadEx5_1();
		t1.start();
		
		startTime = System.currentTimeMillis();
		for(int i=0; i<300; i++) {
			System.out.printf("%s",new String("-"));
		}
		System.out.println("t1 ThreadEx5.startTime : "+startTime );
		System.out.println("t1의 소요시간 :" +(System.currentTimeMillis() - startTime));
	}

}

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s",new String("|"));
		}
		System.out.println("t2 ThreadEx5.startTime : "+ThreadEx5.startTime );
		System.out.println("t2의 소요시간 :" +(System.currentTimeMillis() - ThreadEx5.startTime));
	}
}

class ThreadEx5_2 extends Thread{
	long startTime = System.currentTimeMillis();
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
		}
		System.out.println("t2의 소요시간 :" +(System.currentTimeMillis() - startTime));
	}
}