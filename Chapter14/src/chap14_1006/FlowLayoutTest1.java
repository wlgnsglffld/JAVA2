package chap14_1006;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class FlowLayout1 extends JFrame {
	public FlowLayout1() {
		//프레임으로부터 컨테이너(쟁반) 생성.
		Container ct = getContentPane();
		
		//컨테이너에 컴포넌트를 수직방향으로 연속으로 배치시키는 관리자
		FlowLayout fl = new FlowLayout(FlowLayout.RIGHT, 10, 15);
												//정렬, 수평 간격, 수직 간격
		//컨테이너에 레이아웃 설정
		ct.setLayout(fl);
		
		//15개 버튼 컴포넌트를 생성하여 컨테이너에 추가
		for (int i = 1; i<=25 ; i++)
			ct.add(new JButton("버튼"+i));
		setTitle("FlowLayout Test");
		setSize(500,300);
		
		//윈도우 창 종료시 프로세스 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 출력
		setVisible(true);
	}
}


public class FlowLayoutTest1 {
	public static void main(String[] args) {
		new FlowLayout1();
	}

}
