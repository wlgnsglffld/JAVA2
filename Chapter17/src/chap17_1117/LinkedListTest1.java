package chap17_1117;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest1 {
	public static void main(String[] args) {
		ArrayList<Integer> alist = new ArrayList<Integer>();
		LinkedList<Integer> llist = new LinkedList<Integer>();
		
		int i;
		long start, stop;
		
		start = System.currentTimeMillis();
		for(i = 0; i <= 1000000; i++) {
			alist.add(i);
		}
		stop = System.currentTimeMillis();
		
		System.out.println("ArrayList - 순차적 삽입 시간 :"+ (stop - start));
		
		start = System.currentTimeMillis();
		for(i = 0; i <= 10000000; i++) {
			llist.add(i);
		}
		stop = System.currentTimeMillis();
		
		System.out.println("LinkedList - 순차적 삽입 시간 :"+ (stop - start));
		
		
		//중간 삽입
		start = System.currentTimeMillis();
		for(i = 0; i <= 1000; i++) {
			alist.add(500,i);
		}
		stop = System.currentTimeMillis();
		
		System.out.println("ArrayList - 중간 삽입 시간 :"+ (stop - start));
		
		start = System.currentTimeMillis();
		for(i = 0; i <= 1000; i++) {
			llist.add(500,i);
		}
		stop = System.currentTimeMillis();
		
		System.out.println("LinkedList - 중간 삽입 시간 :"+ (stop - start));
	}

}

