package chap13;

import java.io.File;

public class FileDirTest2 {

	public static void main(String[] args) {
		String dir ="C:/Windows1";
		File f1 = new File(dir); //파일 객체 생성

		try{//if(f1.isDirectory()) 
			System.out.println("검색 디렉토리 : "+dir);
			System.out.println("===============");
			
			//디렉토리의 모든 요소를 문자열의 배열로 생성.
			String s[] = f1.list();
			
			for(int i = 0; i < s.length; i++) {
				//문자열의 항목으로 객체 생성
				File f = new File (dir + "/" + s[i]);
				if(f.isDirectory()) {
					System.out.println(s[i] + " :디렉토리");
				}
				else {
					System.out.println(s[i]+ " : 파일");
				}
			}
		}
		 catch(Exception e){//else
			System.out.println("지정한 "+ dir + "는 디렉토리가 아닙니다.");
			System.out.println(e);
		}
	}

}
