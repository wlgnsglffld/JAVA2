package chap15_1013;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//GUI 클래스 
class JButton1 extends JFrame {
	public JButton1() {
		//이미지 아이콘 객체 생성.
		ImageIcon korea = new ImageIcon("image/korea1.gif");
		ImageIcon usa = new ImageIcon("image/usa.gif");
		ImageIcon germany = new ImageIcon("image/germany.gif");
		
		//버튼 객체 생성.
		JButton nat = new JButton(korea); //기본 버튼 이미지는 태극기.
		nat.setPressedIcon(usa);	//버튼을 누르면 미국 국기.
		nat.setRolloverIcon(germany); //버튼에 마우스를 올리면 독일 국기. 
		// 컨테이너 생성.
		Container ct = getContentPane();
		
		// FlowLayout 배치 관리자 생성.
		ct.setLayout(new FlowLayout());
		
		//컨테이너에 버튼 추가.
		ct.add(nat);
		
		//화면에 보이기. 500,400
		setTitle("JButton Test1");
		setSize(500, 400);
		setVisible(true);
		
	}
}
//메인 클래스
public class JButtonTest1 {

	public static void main(String[] args) {
		new JButton1();
	}

}
