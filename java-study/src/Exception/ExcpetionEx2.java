package Exception;

public class ExcpetionEx2 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		System.out.println("랜덤1 ::" +(int)(Math.random() * 10));
		for(int i=0; i<10; i++) {
			System.out.println("랜덤 ::" +(int)(Math.random() * 10));
			result = number / (int)(Math.random() * 10); 
			System.out.println(result);
		}

	}

}
