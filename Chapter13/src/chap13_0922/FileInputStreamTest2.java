/*
 * 작성일 : 2023년 9월 22일
 * 작성자 : 컴정부 201695026 김지훈
 * 설명 : 파일에 저장된 바이트 내용 가져오기.(출력)
 */

package chap13_0922;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) throws IOException {
		//파일 객체 생성.
		File file = new File("c.txt");
		
		//FileReader 객체 생성
		FileReader fr = new FileReader(file);
		
		//한 문자씩 읽기
		int i;
		while((i = fr.read()) != -1) { //데이터를 모두 읽으면 -1을 반환
			System.out.print((char)i);
		}
		fr.close();
	}

}
