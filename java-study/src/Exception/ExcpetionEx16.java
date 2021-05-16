package Exception;

public class ExcpetionEx16 {

	public static void main(String[] args) {
		try {
			int result = 0/0;
		//} catch(ClassCastException e) {
		} catch(ArithmeticException e) {
			System.out.println("dd");
		} finally {
			System.out.println("finally");
		}

	}

}
