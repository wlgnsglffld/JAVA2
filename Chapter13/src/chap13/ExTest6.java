package chap13;

public class ExTest6 {

	public static void main(String[] args) {
		try {
			method1();
			System.out.println("메소드호출후");
		}
		catch (ArrayStoreException ex) {
			System.out.println("ArrayStoreException 예외 발생");
		}
		catch (ArithmeticException ex) {
			System.out.println("ArithmeticException 예외 발생");
		}

	}
	static void method1() throws RuntimeException{
		int a = 0;
		int b = 2 / a;
		System.out.println("나눗셈후");
	}
}
