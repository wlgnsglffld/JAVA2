package chap15_1010;
/*

 * 독립된 이벤트 처리 클래스를 이용한 이벤트 처리
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//이벤트 처리 클래스
class EventClass implements ActionListener{
	JLabel jl;
	
	//생성자를 통해 JLabel객체 공유
	public EventClass(JLabel jl) {
		this.jl = jl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jl.setText(e.getActionCommand());
	}
}

//GUI클래스 ~ 버튼 2개의 레이블1개
class Event03 extends JFrame{
	//JLabel객체를 속성으로 등록
	JLabel jl;
	
	//JButton객체를 속성으로 2개 등록
	JButton jb1, jb2;
	
	//생성자
	public Event03() {
		//컨테이너 생성
		Container ct = getContentPane();
		//배치 관리자 설정. (FlowLayout)
		ct.setLayout(new FlowLayout());
		
		//버튼 생성
		JButton jb1 = new JButton("안녕하세요.");
		//버튼 생성
		JButton jb2 = new JButton("행복한 하루입니다.");
		//레이블 생성
		jl = new JLabel("버튼을 누르세요.");
		
		//컨테이너에 버튼과 레이블 등록
		ct.add(jb1);
		ct.add(jb2);
		ct.add(jl);
		
		//3. 이벤트를 받아들일 컴포넌트에 리스너 등록
		jb1.addActionListener(new EventClass(jl));
		jb2.addActionListener(new EventClass(jl));

		setTitle("이벤트 테스트3");
		setSize(300, 200);
				
		//윈도우 창 종료시 프로세스 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 출력
		setVisible(true);	
	}
}

public class EventTest03 {

	public static void main(String[] args) {
		new Event03();

	}
}
