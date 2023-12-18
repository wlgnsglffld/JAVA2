import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Main extends JFrame implements ActionListener{
	StudyDAO Sdao = new StudyDAO();
	public Main() {
		//컨테이너 생쉉
		Container ct = getContentPane();
		
		//레이아웃 설정
		ct.setLayout(new FlowLayout());
		
		//버튼 생성 및 추가
		JButton user = new JButton("사용자");
		JButton admin = new JButton("관리자");
		user.setPreferredSize(new Dimension(150, 100));
		admin.setPreferredSize(new Dimension(150, 100));
		
		//컴포넌트에 이벤트 리스너 등록
		user.addActionListener(this);
		admin.addActionListener(this);
		
		//컨테이너에 버튼 추가
		ct.add(user);
		ct.add(admin);
		
		//화면에 보이도록
		setTitle("정보 처리 기사 단어장");
		setSize(335,150);
		
		//윈도우 창 종료시 프로세스 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 출력
		setVisible(true);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
	        JButton source = (JButton) e.getSource();
	        
	        if (source.getText().equals("사용자")) { // '사용자' 버튼을 클릭했을 때
	            UserMenu userMenu = new UserMenu(); // UserMenu 클래스의 인스턴스 생성
	            userMenu.setVisible(true); // 팝업으로 보이도록 설정
	            Sdao.resetIncorr();	//incorr테이블 초기화
	        }
	        else if(source.getText().equals("관리자")) {	//'관리자' 버튼을 클릭했을 때
	        	AdminMenu adminMenu = new AdminMenu();	//AdminMenu 클래스의 인스턴스 생성
	        	AdminMenu.setVisible(true);	//팝업으로 보이도록 설정
	        }
		}
		
	}
	
}


public class MainMenu {

	public static void main(String[] args) {
		new Main();
	}

}
