package ObjectOrientedProgramming2;

interface IB{
	public void methodB();
}

class A2 {
	public void methodA(IB ib) {
		ib.methodB();
	}
}

class B2 implements IB{
	public void methodB() {
		System.out.println("methodB");
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		
		A2 a = new A2();
		IB b = new B2();
		a.methodA(b);

	}

}
