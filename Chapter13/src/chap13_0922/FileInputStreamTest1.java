/*
 * 작성일 : 2023년 9월 22일
 * 작성자 : 컴정부 201695026 김지훈
 * 설명 : 파일에 저장된 바이트 내용 가져오기.(출력)
 */

package chap13_0922;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileInputStreamTest1 {

	public static void main(String[] args) throws IOException {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("읽을 파일명을 입력하세요. : ");
		String sfile = stdIn.next(); //문자열로 입력된 파일명 저장.
		
		//읽어들일 파일명으로 객체 생성.
		FileInputStream fis = new FileInputStream(sfile);
		
		
		fis.close();
		System.out.println("\n" + sfile + " 파일로부터 바이트를 읽어 화면에 출력하였습니다.");
	}

}
