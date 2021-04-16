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
		//�ν��Ͻ�Ŭ������ �ν��Ͻ��� �����Ϸ���
		//�ܺ�Ŭ������ �ν��Ͻ��� ���� �����ؾ���.
		Outer outer = new Outer();
		Outer.InstanceInner instanceInner = outer.new InstanceInner();
		
		System.out.println("instanceInner.iv : "+ instanceInner.iv);
		System.out.println("Outer.StaticInner.cv: "+ Outer.StaticInner.cv);
		
		//����ƽ ���� Ŭ������ �ν��Ͻ��� �ܺ� Ŭ������ ���� �������� �ʾƵ� ��.
		Outer.StaticInner staticInnerClass = new Outer.StaticInner();
		System.out.println("Outer.StaticInner.iv: "+ staticInnerClass.iv);

	}

}
