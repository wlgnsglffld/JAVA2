package chap15_1017;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 1. 처리할 이벤트 종류 결정. -버튼
// 2. 이벤트에 적합한 이벤트 리스너 인터페이스를 사용하여 클래스 작성.
class GUI1 extends JFrame{
	//속성으로 텍스트 에어리어와 텍스트 필드를 선언.
	private JTextArea contents;
	private	JTextField f_name;
	//생성자
public GUI1() {
	
	//컨테이너 생성.
	Container ct = getContentPane();
	// FlowLayout 설정.
	ct.setLayout(new FlowLayout());
	// 패널 생성.
	JPanel p1 = new JPanel();
	
	//판넬에 텍스트 필드 추가
	p1.add(f_name);
	
	//컨테이너에 텍스트 에어리어 추가
	ct.add(contents);
	//컨테이너에 판넬 추가
	ct.add(p1);
	
	
	//화면 크기, 보이기, 타이틀 
	setTitle("GUI Test1");
	setSize(500,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}



public class GUITest1 {
	public static void main(String[] args) {
		new GUI1();

}
}
}