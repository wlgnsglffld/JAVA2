package chap13_0926;

import java.io.FileWriter;
import java.io.IOException;

public class FileIOTEest1 {

	public static void main(String[] args) throws Exception {
		String source = "Have a good day. Hava a nice day! Have good? Hvae fun?";
		char intxt[] = new char[source.length()];
		//문자열 크기의 문자 배열 생성
		source.getChars(0, source.length(), intxt, 0); 
		//입력배열을 intxt 문자 배열에 저장
		
		FileWriter fw = new FileWriter("temp.txt");
		fw.write(intxt); 
		//문자 배열의 내용을 파일에 출력
		
		fw.close();


	}

}
