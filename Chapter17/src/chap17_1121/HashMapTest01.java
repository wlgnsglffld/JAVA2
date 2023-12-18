package chap17_1121;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest01 {
	public static void main(String[] args) {
		// HashMap 객체 생성.
		HashMap<String,String> dict = new HashMap<String,String>();
		
		// 3개의 (key, value) 로 이루어진 값을 dict에 저장
		dict.put("사과", "apple");
		dict.put("딸기", "strawberry");
		dict.put("포도", "grape");
		
		// 사용자로부터 한글 단어를 입력 받아 영어 단어 검색
		Scanner stdIn = new Scanner(System.in);
		while(true)
		{
			System.out.println("알고 싶은 과일 이름을 입력하세요. (0은 종료) ");
			String kor = stdIn.next();
			
			// 0 입력 시 프로그램 종료.
			if (kor.equals("0")) 
			{
                System.out.println("프로그램을 종료합니다.");
                break; 
            }
			// 해시맵에서 키 kor에 해당하는 값 eng 검색
			String eng = dict.get(kor);
			if(eng == null) {
				System.out.println(kor+ "는 없는 단어 입니다.");
			}
			else {
				System.out.println(eng);
			}
		}

	}

}
//학번 	이름		전화번호			이메일
//1001	김지훈		010-7761-2076	jh@mail.com
//1002	강하늘		010-4567-8901	kang@mail.com
//1003	박소담		010-7896-4561	park@mail.com
//이 학생 정보를 모두 출력하고 학번을 입력하면 해당 학생의 정보가 출력되게한다
//학번을 입력하면 학생 정보 이름 전화번호 이메일이 나오게 해서 HashMap 사용해서 각 코드에 주석 달아서 알려줘
//클래스 명은 FinalExam01이야