package chap15_1010;
/*

 * GUI클래스에서 이벤트 처리하는 방법
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

							//1. 처리할 이벤트 종류 결정 - ActionEvent
							//2. 이벤트에 적합한 이벤트 리스너 인터페이스를 사용하여 클래스 작성 -ActionListener
class Event01 extends JFrame implements ActionListener{
	JLabel jl; //JLabel객체를 속성으로 등록
	public Event01() {
		//컨테이너 생성
		Container ct = getContentPane();
		//배치 관리자 설정. (FlowLayout)
		ct.setLayout(new FlowLayout());
		
		//버튼 생성
		JButton jb = new JButton("버튼");
		//레이블 생성
		jl = new JLabel("버튼을 눌러 주세요.");
		
		//컨테이너에 버튼과 레이블 등록
		ct.add(jb);
		ct.add(jl);
		
		//3. 이벤트를 받아들일 컴포넌트에 리스너 등록
		jb.addActionListener(this); //버튼 객체에 리스너 등록
		
		setTitle("이벤트 테스트1");
		setSize(300, 200);
		
		//윈도우 창 종료시 프로세스 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 출력
		setVisible(true);
	}

	//4.리스너 인터페이스에 선언된 메소드를 오버라이딩하여 이벤트 처리 루틴 작성
	@Override
	public void actionPerformed(ActionEvent e) {
		jl.setText("안녕하세요");
	}
}

public class EventTest01 {

	public static void main(String[] args) {
	new Event01();
	}

}
