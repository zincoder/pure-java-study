package ObjectOrientedProgramming2;

public class InnerEx6 {
	Object iv = new Object() {void method(){}};			//�͸� Ŭ����
	static Object cv = new Object() {void method(){}};  //�͸� Ŭ����
	
	void method() {
		Object lv = new Object() {void method(){}};		//�͸� Ŭ����
	}
}
