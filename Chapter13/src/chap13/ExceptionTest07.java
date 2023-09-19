/*
 * 나이를 입력받아 출력하시오.
 * 입력받은 나이가 정수가 아닌 경우 예외처리 하시오.
 */
package chap13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest07 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int num1=0;
		try {
			num1 = stdIn.nextInt();
			System.out.println("당신의 나이는 "+num1+"살 입니다.");
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();0
			System.out.print("나이는 정수로 입력하세요. ");
		}
		
		
		
	}
	

}
