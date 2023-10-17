package chap14_1010;

//GUI클래스 -이벤트 포함

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JLabel01 extends JFrame implements ActionListener{
	private JLabel result = new JLabel();
	public ImageIcon img1, img2;
	
	public JLabel01() {
		//이미지 생성.
		img1 = new ImageIcon("image\\apple.jpg");
		img2 = new ImageIcon("image/pear.jpg");
		
		//버튼 생성
		JButton apple = new JButton("사과");
		JButton pear = new JButton("배");
		
		//컨테이너 생성
		Container ct = getContentPane();
		//배치 관리자 생성 - FlowLayout
		ct.setLayout(new FlowLayout());
		
		//컨테이너에 버튼과 라벨 추가
		ct.add(apple);
		ct.add(pear);
		ct.add(result);
		
		//버튼에 리스너 등록
		apple.addActionListener(this);
		pear.addActionListener(this);
		
		//화면에 보여주기
		setTitle("버튼을 누르면 이미지 보여주기");
		setSize(300, 200);
				
		//윈도우 창 종료시 프로세스 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 출력
		setVisible(true);	
	}

	//리스너 인터페이스에 선언된 메소드를 오버라이딩하여 이벤트처리 루틴 작성
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "사과") {
			result.setIcon(img1);
			result.setText("맛있는 사과 입니다.");
		}
		if(e.getActionCommand() == "배") {
			result.setIcon(img2);
			result.setText("좋아하는 배입니다.");
		}
	}
}

//메인 클래스
public class JLabelTest01 {

	public static void main(String[] args) {
		new JLabel01();
	}

}
