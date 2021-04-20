package Thread;

public class ThreadEx20 {

	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		for(int i=0; i<20; i++) {
			requiredMemory = (int)(Math.random() * 10) * 20;
			
			//�ʿ��� �޸𸮰� ����� �� �ִ� �纸�� ũ�ų� ��ü �޸��� 60%�̻��� ������� ��� gc�� ����.
			if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory()* 0.4) { //���ڰ� �ִ� gc�� ����
				gc.interrupt();
				try {
					gc.join(1000);
				}catch(InterruptedException e) {}
			}
			
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory:"+gc.usedMemory);
		}

	}

}

class ThreadEx20_1 extends Thread{
	final int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10 * 1000); //10�ʸ� ��ٸ�
			} catch(InterruptedException e) {
				System.out.println("Awaken by interrupt().");
			}
			
			gc();  //garbage collection�� ����
			System.out.println("Garbage Collection. Free Memory :"+ freeMemory()); 
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) usedMemory = 0;
	}
	public int totalMemory() { return MAX_MEMORY;}
	public int freeMemory() {return MAX_MEMORY - usedMemory;}
}