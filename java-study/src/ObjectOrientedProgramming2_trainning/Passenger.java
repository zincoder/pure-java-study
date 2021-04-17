package ObjectOrientedProgramming2_trainning;

public class Passenger {
	int money;
	boolean isTakeBus = false;

	Passenger(){
		this(1500);
	}
	
	Passenger(int money){
		this.money = money;
	}
	
	boolean pay(int fee) {
		System.out.println("���� ����� "+fee+"�Դϴ�.");
		if(money < fee) {
			System.out.println("���� �ܾ��� "+money+"�̹Ƿ� ���� �����Ͽ� ������ Ż �� �����ϴ�.");
			return false;
		}
		money -= fee;
		System.out.println("��� "+ fee +"���� �����մϴ�.");
		System.out.println("���� �ܾ��� "+ money +"�Դϴ�.");
		return true;
	}
	
	boolean takeBus(int fee, Bus bus, int seat) {
		System.out.println("���� ž�¹����� �ܿ��¼��� "+seat+"�� �Դϴ�.");
		if(!isTakeBus) {
			if(seat > 0) {
				if(pay(fee)) {
					System.out.println("������ ž���մϴ�.");
					bus.recieveMoney();
					isTakeBus = true;
					return true;
				}else {
					System.out.println("������ ž������ ���߽��ϴ�.");
					return false;
				}
			}else {
				System.out.println("�¼��� �����Ͽ� ������ ž���� �� �����ϴ�.");
			}
		} else {
			System.out.println("�̹� ������ ž���� �����̹Ƿ� �ٸ� ������ ž���� �� �����ϴ�.");
		}
		return false;
	}
	
	void getOffBus(Bus bus) {
		if(isTakeBus) {
			isTakeBus = false;
			System.out.println("�������� �����ϴ�.");	
			bus.getOffPassenger();
		}else {
			System.out.println("������ ž���� ���� �����Ƿ� ���� �� �����ϴ�.");	
		}
	}
}
