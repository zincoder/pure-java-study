package ObjectOrientedProgramming2;

class Outer{
	class InstanceInner{
		int iv = 100;
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 300;
	}
	
	void myMethod() {
		class LocalInner{
			int iv = 400;
		}
	}
}

public class InnerEx4 {

	public static void main(String[] args) {
		//인스턴스클래스의 인스턴스를 생성하려면
		//외부클래스의 인스턴스를 먼저 생성해야함.
		Outer outer = new Outer();
		Outer.InstanceInner instanceInner = outer.new InstanceInner();
		
		System.out.println("instanceInner.iv : "+ instanceInner.iv);
		System.out.println("Outer.StaticInner.cv: "+ Outer.StaticInner.cv);
		
		//스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 됨.
		Outer.StaticInner staticInnerClass = new Outer.StaticInner();
		System.out.println("Outer.StaticInner.iv: "+ staticInnerClass.iv);

	}

}
