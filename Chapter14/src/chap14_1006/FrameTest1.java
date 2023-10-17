package chap14_1006;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

//클래스 생성.
 class FirstFrame {
	//생성자
	 public FirstFrame() {
	//프레임 객체 생성.
	JFrame jf = new JFrame ("첫 번째 GUI 프로그램");

	//프레임으로부터 컨테이너(쟁반) 생성.
	Container ct = jf.getContentPane();
	
	//버튼 컴포넌트 생성.
	JButton jb = new JButton("테스트 버튼1");
	
	//컨테이너에 버튼 추가
	ct.add(jb);
	
	//프레임 크기
	jf.setSize(400,300);
	
	//프레임을 화면에 출력
	jf.setVisible(true);
	}
}
public class FrameTest1{
	public static void main(String[] args) {
		new FrameTest1();

	}
}