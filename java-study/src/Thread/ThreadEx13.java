package Thread;

import javax.swing.JOptionPane;

public class ThreadEx13 {

	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� "+input+" �Դϴ�.");
		th1.interrupt(); //interrupt()�� ȣ���ϸ�, interrupted ���°� true�� ��.
		System.out.println("isInterrupted():"+th1.isInterrupted());//true
	}

}

class ThreadEx13_1 extends Thread{
	public void run() {
		int i=10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0; x<2500000000L; x++);//�ð�����
			
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}
}