package chap17_1117;

import java.util.TreeSet;

public class TreeSetLotto {
	public static void main(String[] args) {
		TreeSet<Integer> lotto_num = new TreeSet<Integer>();
		
		while(lotto_num.size() < 6 ) {
			int num = (int)(Math.random() * 45)+1 ;
			lotto_num.add(num);
		}
		System.out.println(lotto_num);
		

	}

}
