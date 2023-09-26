package chap13_0926;
//파일에 쓰기 저장

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

//이 클래스를 직렬화 할것임을 지정.
class PersonInfo implements Serializable{
	String name;	//멤버변수.
	String city;
	int age;
	
	//생성자
	//this 이유는 생성자의 매개변수를 멤버변수에 저장하겠다는 의미
	public PersonInfo(String name, String city, int age) {
		this.name = name;	//매개변수로 전달받은 값을 멤버 변수에 저장.
		this.city = city;
		this.age = age;
	}
}
public class ObjectWrite01 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner stdin = new Scanner(System.in);
		System.out.print("출력 파일명을 입력하세요 : ");
		String fileName = stdin.next();

		String s1 = "***고객 정보***";
		
		//직렬화된 객체를 2개 생성  >> PersonInfo에 생성자를 만들었기 때문에
		PersonInfo p1 = new PersonInfo("김지훈", "부산", 27);
		PersonInfo p2 = new PersonInfo("이지선", "김해", 23);
		
		//직렬화된 객체를 2진수로 기록할 파일을 지정. >> fileName
		//객체를 기록할 수 있는 objextOutputStream 객체 생성.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		
		//직렬화된 객체를 파일에 2진수로 기록한다.
		oos.writeObject(s1);	//1번
		oos.writeObject(p1);	//2번
		oos.writeObject(p2);	//3번
		
		oos.close();
		System.out.println(fileName + " 파일명으로 객체 파일을 생성하였습니다.");
	}

}
