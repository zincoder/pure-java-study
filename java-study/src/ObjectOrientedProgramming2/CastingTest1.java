package ObjectOrientedProgramming2;

public class CastingTest1 {

	public static void main(String[] args) {
	
		Car1 c1 = null;
		FireEngine1 fe1 = new FireEngine1();
		FireEngine1 fe2 = null;
		
		c1 = fe1;
		fe2 = (FireEngine1)c1;

	}

}

class Car1{
	String color;
	int door;
	
	void drive() { //�����ϴ� ���
		System.out.println("����!");
	}
	
	void stop() { //���ߴ� ���
		System.out.println("����!");
	}
}

class FireEngine1 extends Car1{
	void water() {
		System.out.println("water!!");
	}
}
