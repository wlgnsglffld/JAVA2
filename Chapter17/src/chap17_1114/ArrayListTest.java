package chap17_1114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
		//문자열 배열 생성
		String[] name = {"kim", "lee", "park", "jung", "oh"};
		
		//문자열의 배열을 이용하여 리스트 객체(제네릭)생성.
		ArrayList<String> lname = new ArrayList<String>(Arrays.asList(name));
		System.out.println("초기값 : " + lname);
		
		//리스트 끝에 'ha' 추가
		lname.add("ha");
		System.out.println("ha 추가 후 리스트 값 : " + lname);
		
		// 0 번지에 '김' 변경
		lname.set(0,"김");
		// 3 번지에 '최' 추가
		lname.add(3,"최");
		System.out.println("0번지 김으로 변경 3번지 최 추가 : " + lname);
		
		// 무작위 재배치 -> Collections 클래스의 메소드 이용.
		Collections.shuffle(lname);
		System.out.println("shuffle() 메소드 적용 리스트 값 : " + lname);
		
		// 정렬 -> sort ()
		Collections.sort(lname);
		System.out.println("sort() 메소드 적용 리스트 값 : " + lname);
		
		// 5번째 값 출력
		System.out.println("5번째 값 : " + lname.get(4));
		
		// 리스트의 모든 요소를 '김'으로 채우기
		Collections.fill(lname, "김");
		System.out.println("모든 요소를 \"김\" 으로 채우기" + lname);
		}

	}

