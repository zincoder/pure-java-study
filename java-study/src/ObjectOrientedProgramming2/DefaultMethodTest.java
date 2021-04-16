package ObjectOrientedProgramming2;

public class DefaultMethodTest {

	public static void main(String[] args) {

		Child4 c = new Child4();
		c.method1();
		c.method2();
		MyInterface.staticMethod();
		MyInterface2.staticMethod();
		
		MyInterface2 m = new Child4();
	}

}

class Child4 extends Parent4 implements MyInterface, MyInterface2{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		MyInterface2.super.method1();
	}
	/*public void method1() {
		System.out.println("method1() in Child4");
	}*/
}

class Parent4{
	public void method2() {
		System.out.println("method2() in Parent4");
	}
}

interface MyInterface{
	default void method1() {
		System.out.println("method1() in MyInterface");
	}
	
	default void method2() {
		System.out.println("method2() in MyInterface");
	}
	
	static void staticMethod() {
		System.out.print("staticMethod() in MyInterface");
	}
}

interface MyInterface2{
	default void method1() {
		System.out.println("method1() in MyInterface2");
	}
	
	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface2");
	}
}