package Thread_Ex2;

public class Park extends Thread{
	@Override
	public void run() {
		BankMain.myBank.saveMoney(5000);
		System.out.println("���� ���� �� �ܰ� Ȯ�� :" + BankMain.myBank.getMoney());
	}
}