package ObjectOrientedProgramming2_trainning;

public class LocalBus extends Bus{

	int income;
	int fee = 500;
	int seat = 4;
	
	@Override
	void setDestination() {
		System.out.println("��ȭ������ ���� �����Դϴ�.");
	}
	
	void recieveMoney() {
		income += fee; 
		System.out.println("���� ������ ������ "+income +"�Դϴ�.");
		pickUpPassengers();
	}
	
	//�°��� �¿�
	void pickUpPassengers(){
		seat -= 1;
		setDestination();
	}		
	
	//�°��� ����
	void  getOffPassenger() {
		seat += 1;
	}
	
	public String toString() {
		return "��������";
	}


}
