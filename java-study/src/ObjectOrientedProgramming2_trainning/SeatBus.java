package ObjectOrientedProgramming2_trainning;

public class SeatBus extends Bus{

	int income;
	int fee = 1000;
	int seat = 2;
	
	@Override
	void setDestination() {
		System.out.println("�� ������ ��������  �������Դϴ�.");
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
		return "�¼�����";
	}
	
}
