package chap14_1006;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class JPanel2 extends JFrame{
	public JPanel2() {
		//프레임으로부터 컨테이너(쟁반) 생성.
		Container ct = getContentPane();
	
		//배치 관리자 설정 BorderLayout    >> 동서남북
		ct.setLayout(new BorderLayout(5, 5));
		
		//판넬 1 객체를 생성.
		JPanel jp1 = new JPanel();
		
		// 판넬1에 GridLayout 배치 관리자 설정... 5줄 1칸
		jp1.setLayout(new GridLayout(5, 1));
		
		//판넬1(jp1)에 라디오버튼 추가
		jp1.add(new JRadioButton("자바"));
		jp1.add(new JRadioButton("C언어"));
		jp1.add(new JRadioButton("JAVA Script"));
		jp1.add(new JRadioButton("JSP"));
		jp1.add(new JRadioButton("C#"));
		
		//판넬 2 객체를 생성.
		JPanel jp2 = new JPanel();
		
		// 판넬1에 GridLayout 배치 관리자 설정... 5줄 1칸
		jp2.setLayout(new GridLayout(5, 1));
		
		//판넬2 (jp2)에 버튼 추가
		jp2.add(new JButton("자바"));
		jp2.add(new JButton("C언어"));
		jp2.add(new JButton("JAVA Script"));
		jp2.add(new JButton("JSP"));
		jp2.add(new JButton("C#"));
		
		//판넬 3 객체를 생성.
		JPanel jp3 = new JPanel();
		
		// 판넬3에 GridLayout 배치 관리자 설정... 1줄 1칸
		jp3.setLayout(new GridLayout(1, 1));
		
		//판넬 3에 레이블 추가
		jp3.add(new JLabel("좋아하는 프로그래밍 언어를 선택하세요."));
		
		//컨테이너에 판넬 올리기(추가)
		ct.add(jp1, BorderLayout.WEST);
		ct.add(jp2, BorderLayout.EAST);
		ct.add(jp3, BorderLayout.NORTH);
		setTitle("Jpanel Test2");
		setSize(300, 200);
		//윈도우 창 종료시 프로세스 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 출력
		setVisible(true);
	}
}
public class JPanelTest2 {
	public static void main(String[] args) {
		new JPanel2();

	}

}
