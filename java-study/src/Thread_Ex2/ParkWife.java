package Thread_Ex2;

public class ParkWife extends Thread{
	@Override
	public void run() {
		BankMain.myBank.minusMoney(2000);
		System.out.println("¾Æ³» Ãâ±Ý ÈÄ ÀÜ°í È®ÀÎ :" + BankMain.myBank.getMoney());
	}
}