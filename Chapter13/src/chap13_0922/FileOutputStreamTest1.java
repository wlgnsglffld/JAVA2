/*
 * 작성일 : 2023년 9월 22일
 * 작성자 : 컴정부 201695026 김지훈
 * 설명 : 바이트 단위로 파일에 저장.(파일 생성)
 */

package chap13_0922;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputStreamTest1 {

	public static void main(String[] args) throws IOException {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("저장 파일명을 입력하세요. : ");
		String sfile = stdIn.next();
		
		//파일명으로 객체 생성.
		FileOutputStream fos = new FileOutputStream(sfile);
		
		int i;
		for(i = 1; i <=260; i++) {
			fos.write(i);//파일에 내용 쓰기.(저장)
		}
		fos.close();
		System.out.println(sfile + "파일명으로 바이트 파일을 생성하였습니다.");
	}

}
