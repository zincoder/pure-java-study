package ObjectOrientedProgramming2;

public class InterfaceTest3 {

	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA();

	}

}

class A3{
	void methodA() {
		I3 i = InstanceManager3.getInstance();
		i.methodB();
		System.out.println(i.toString()); 
	}
}

interface I3 {
	void methodB();
}

class B3 implements I3{

	@Override
	public void methodB() {
		System.out.println("methodB");
	}
	
	public void methodB2() {
		System.out.println("methodB2");
	}
	
	public String toString() {
		return "classB3";
	}
	
}

class InstanceManager3 {

	public static I3 getInstance() {
		return new B3();
	}
	
}