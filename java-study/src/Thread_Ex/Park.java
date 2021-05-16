package Thread_Ex;

public class Park extends Thread{
	@Override
	public void run() {
		BankMain.myBank.saveMoney(5000);
		System.out.println("남편이 출금 :" + BankMain.myBank.getMoney());
	}
}