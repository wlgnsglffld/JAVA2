package chap13_0926;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ObjectRead01 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner stdin = new Scanner(System.in);
		System.out.print("입력 파일명을 입력하세요 : ");
		String fileName = stdin.next();

		//객체를 읽을 수 있는 ObjectInputStream 객체 생성.
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		
		//직렬화된 객체 읽어오기.
		Object s2 = ois.readObject();
		
		//readObject() 메소드로 직렬화된 객체의 2진 데이터를 읽어서 객체 타입으로 개스팅(형변환)한다.
		PersonInfo p1 = (PersonInfo)ois.readObject();
		PersonInfo p2 = (PersonInfo)ois.readObject();
		
		//출력한 순서대로 입력해야 한다.
		System.out.println(s2);	//1번
		System.out.println("이름 : " + p1.name);	//2번
		System.out.println("주소 : " + p1.city);	
		System.out.println("나이 : " + p1.age);	
		System.out.println("----------------");
		System.out.println("이름 : " + p2.name);	//3번
		System.out.println("주소 : " + p2.city);	
		System.out.println("나이 : " + p2.age);	
		
		ois.close();
	}

}
