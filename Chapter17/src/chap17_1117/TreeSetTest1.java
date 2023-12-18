package chap17_1117;

import java.util.LinkedList;
import java.util.TreeSet;

public class TreeSetTest1 {

	public static void main(String[] args) {
		// TreeSet 객체 생성.
		TreeSet<Integer> num1 = new TreeSet<Integer>();
		TreeSet<Integer> num2 = new TreeSet<Integer>();
		
		int i ;
		
		for(i = 4; i >=0; i--) {
			num1.add(i);
			num2.add(i*2);
		}
		
		//순서에 상관없이 항상 정렬되어 출력된다.
		System.out.println("num1 집합의 내용 :" + num1);
		System.out.println("num1 집합의 내용 :" + num2);

		TreeSet<Integer> union = new TreeSet<Integer>(num1);
		TreeSet<Integer> intersection = new TreeSet<Integer>(num1);
		TreeSet<Integer> difference = new TreeSet<Integer>(num1);
		
		union.addAll(num2);	//합집합
		intersection.retainAll(num2); //교집합
		difference.removeAll(num2); // 차집합.
		
		System.out.println("합집합의 내용 :" + union); //중복된 값은 출력하지 않는다.
		System.out.println("교합의 내용 :" + intersection);
		System.out.println("차합의 내용 :" + difference);
		
		
		
		
		// LinkedList 객체 생성
		LinkedList<Integer> num3 = new LinkedList<Integer>();
		LinkedList<Integer> num4 = new LinkedList<Integer>();
		
		for(i = 4; i >=0; i--) {
			num3.add(i);
			num4.add(i*2);
		}
		System.out.println("num3 집합의 내용 :" + num3);
		System.out.println("num4 집합의 내용 :" + num4);
		
		LinkedList<Integer> union1 = new LinkedList<Integer>(num3);
		LinkedList<Integer> intersection1 = new LinkedList<Integer>(num3);
		LinkedList<Integer> difference1 = new LinkedList<Integer>(num3);
		
		union1.addAll(num4);	//합집합
		intersection1.retainAll(num4); //교집합
		difference1.removeAll(num4); // 차집합.
		
		System.out.println("합집합의 내용 :" + union1); //
		System.out.println("교합의 내용 :" + intersection1);
		System.out.println("차합의 내용 :" + difference1);
	}

}
