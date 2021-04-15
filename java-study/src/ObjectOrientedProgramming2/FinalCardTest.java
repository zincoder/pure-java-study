package ObjectOrientedProgramming2;

class Card3{
	final int NUMBER; //������� ����� �Բ� �ʱ�ȭ ���� �ʰ�
	final String KIND; //�����ڿ��� �� �ѹ��� �ʱ�ȭ�� �� ����
	static int width = 100;
	static int height = 250;
	
	//�Ű������� �Ѱܹ��� ������ KIND�� NUMBER�� �ʱ�ȭ
	Card3(String kind, int num){
		KIND = kind;
		NUMBER = num;
	}
	
	Card3(){
		this("HEART", 1);
	}
	
	public String toString() {
		return KIND +" "+ NUMBER;
	}
}

public class FinalCardTest {

	public static void main(String[] args) {
		
		Card3 c = new Card3("HEART", 10);
		//c.NUMBER = 5; //�Ұ�
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
	}

}
