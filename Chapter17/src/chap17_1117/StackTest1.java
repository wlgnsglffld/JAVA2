package chap17_1117;

import java.util.Scanner;
import java.util.Stack;

public class StackTest1 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		//사용자로부터 4개의 과일 이름을 입력 받아 stack에 저장
		Scanner stdIn = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			System.out.print("과일 이름을 입력하세요 :");
			String fruits = stdIn.next();
			stack.push(fruits);
		}
		System.out.println("과일 리스트<스택> : " + stack);
		
		//스택에서 과일 찾기
		System.out.print("찾고 싶은 과일 이름을 입력하세요 :");
		String f_name = stdIn.next();
		int fruit = stack.search(f_name);
		if(fruit != -1) {
			System.out.println("스택에서 " + f_name + "의 위치는" + fruit +"번째입니다");
		}
		else {
			System.out.println("스택에서 " + f_name + "가 없습니다.");
		}
		
		//스택 데이터 삭제
		System.out.println("과일 리스트<스택> 삭제 ");
		while(!stack.empty()) {
			String obj = stack.pop();
			System.out.println("<스택>에서 pop : " + obj);
		}
	}

}
