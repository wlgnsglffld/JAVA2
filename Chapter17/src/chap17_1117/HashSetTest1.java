package chap17_1117;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest1 {
	public static void main(String[] args) {
		// HashSet 객체 생성
		HashSet<Integer> odd = new HashSet<Integer>();
		HashSet<Integer> even = new HashSet<Integer>();
		
		for(int i=1; i<=10; i=i+2) {
			odd.add(i);
			even.add(i+1);
		}
		
		// 셋어 저장된 내용 출력
		System.out.println("odd 집합의 내용 : " + odd);
		System.out.println("even 집합의 내용 : " + even);
		
		
		boolean setChanged = odd.add(5);
		System.out.println("odd에 5 추가 성공? : " + setChanged);
		// false -> 중복을 허용하지 않는다
		
		setChanged = even.add(12);
		System.out.println("even에 12 추가 성공? : " + setChanged);
		
		System.out.println("odd 집합의 내용 : " + odd);
		System.out.println("even 집합의 내용 : " + even);
		
		// 최대 최소값 찾기
		System.out.println("odd에서 가장 작은 값은 : " + Collections.min(odd));
		System.out.println("even에서 가장 큰 값은 : " + Collections.max(even));
		
		// HashSet 의 각 요소를 순차 검색하여 합계 계산
		// 순차적으로 만들기 위해 Iterator 사용
		Iterator<Integer> odd_it = odd.iterator();
		int sum = 0;
		
		//odd에 있는 요소를 순차적으로 검색
		while(odd_it.hasNext()) {
			sum = sum + odd_it.next();
		}
		System.out.println("odd 집합의 합은 :"+sum);
		
		// 순차적으로 만들기 위해 Iterator 사용
		Iterator<Integer> even_it = even.iterator();
		sum = 0;

		// even에 있는 요소를 순차적으로 검색
		while (even_it.hasNext()) {
			sum = sum + even_it.next();
		}
		System.out.println("even 집합의 합은 :" + sum);
	}

}
