package ObjectOrientedProgramming2_trainning;

public abstract class Bus {
	int income;
	int fee;
	int seat;

	//����
	void goStraight() {
		System.out.println("������ �մϴ�.");
	};
	
	//��ȸ��
	void turnRight() {
		System.out.println("��ȸ���� �մϴ�.");
	}
	
	//��ȸ��
	void turnLeft(){
		System.out.println("��ȸ���� �մϴ�.");
	}
	
	//����
	void stop(){
		System.out.println("����ϴ�.");
	}
		
	//���� ����
	abstract void recieveMoney();

	//�°��� �¿�
	abstract void pickUpPassengers();
	
	//�°��� ����
	abstract void  getOffPassenger();

	
	//���� ������ ����
	abstract void setDestination();
}
