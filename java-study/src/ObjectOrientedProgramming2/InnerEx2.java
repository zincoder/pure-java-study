package ObjectOrientedProgramming2;

public class InnerEx2 {

	class InstanceInner {}
	static class StaticInner {}
	
	//인스턴스 멤버 간에는 서로 직접 접근이 가능함.
	InstanceInner iv = new InstanceInner();
	//static멤버 간에는 직접 접근이 가능함.
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		//static멤버는 인스턴스멤버에 직접 접근할 수 없음.
		//InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		//굳이 접근하려면 아래와 같이 객체를 생성해야함.
		//인스턴스클래스는 외부 클래스를 먼저 생성해야만 생성할 수 있음.
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj1 = outer.new InstanceInner();
	}
	
	void instanceMethod() {
		//인스턴스메서드에서는 인스턴스멤버와 static멤버 모두 접근 가능함.
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		//메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없음.
		//LocalInner lv = new LocalInner();
	}
	
	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
