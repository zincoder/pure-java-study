package ObjectOrientedProgramming2;

class Outer5{
	int value = 10; //Outer.this.value
	
	class Inner{
		int value = 20; //this.value
		
		void method1() {
			int value = 30;
			System.out.println("			value :"+value);	
			System.out.println("	   this.value :"+this.value);	
			System.out.println("Outer5.this.value :"+Outer5.this.value);	
		}
	} //Inner클래스의 끝
}//Outer클래스의 끝

public class InnerEx5 {

	public static void main(String[] args) {
		Outer5 outer = new Outer5();
		Outer5.Inner inner = outer.new Inner();
		inner.method1();
	}

}
