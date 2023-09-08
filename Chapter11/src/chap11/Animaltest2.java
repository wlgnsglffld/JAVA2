package chap11;
/*
 * 작성일 : 2023년 9월 8일
 * 작성자 : 컴퓨터정보공학부 201695026 김지훈
 * 설명 : 추상클래스 - 동물의 울음소리를 출력하자.
 * 		클래스 메소드
 */

// 추상 클래스 - 동물
abstract class myAnimal2 {
	//추상 메소드 : 동물의 소리를 반환하는 메소드
	abstract String sound2(); 
	
	//클래스 메소드 : 동물의 기본 정보 출력하는 메소드
	static void displayInfo2() {
		System.out.println("동물의 울음소리 입니다.");
	}
}

//고양이 클래스 - 추상 클래스 상속
class myCat2 extends myAnimal2{
	@Override
    String sound2() {
		// 재정의.
        return "야옹~~";
    }

	//@Override
	static void displayInfo2() {// static 메소드는 정적 메소드로 상속된다.즉 오버라이딩 불가능.
		System.out.println("고양이 울음소리 입니다.");
	}
	
}

public class Animaltest2 {

	public static void main(String[] args) {
		myAnimal2 cat2 = new myCat2();//하위 클래스로 선언
		
		cat2.displayInfo2();
		System.out.println(cat2.sound2()+ "입니다.");

	}

}
