package chap15_1017;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ActionEvent2 implements ActionListener{
	private JTextField f_name;
	private JTextArea content;
	
	public ActionEvent2(JTextField f_name, JTextArea content) {
		this.f_name = f_name;
		this.content = content;
	}
	@Override
	public void actionPerformed(java.awt.event.ActionEvent ae) {
		try {
			//입출력을 위한 예외처리
			// 파일 이름으로 출력 객체 생성.
			String s = f_name.getText();
			FileInputStream fis = new FileInputStream(s);
			DataInputStream dis = new DataInputStream(fis);
			
			//파일의 내용을 텍스트 에어리어 내용으로 설정
			content.setText(dis.readUTF());
			//파일 닫기
			fis.close();
			System.out.println(s+"파일을 읽어왔습니다.");
		}
		catch(Exception e){
			
		}
	}	
}

class GUI2 extends JFrame{
	private JTextArea content;
	private JTextField f_name;
	
	public GUI2() {
	//텍스트 필드 객체 생성.
    content = new JTextArea(10, 20);
	//텍스트 에어리어 객체 생성
	f_name = new JTextField("파일명을 입력해주세요.", 20);
	//버튼 객체 생성
	JButton jb = new JButton("파일을 불러오기");
	//텍스트 에어리어는 수정 불가 설정
	content.setEditable(false);
	
	//컨테이너 생성
	Container ct = getContentPane();
	//배치 관리자 생성 - FlowLayout
	ct.setLayout(new FlowLayout());
	//패널 생성.
	JPanel pl = new JPanel();
	
	//컨테이너
	ct.add(pl);
	ct.add(content);
	
	//패널
	pl.add(f_name);
	pl.add(jb);
	
	//컴포넌트에 리스너 등록
	jb.addActionListener(new ActionEvent2(f_name, content));

	setTitle("GUI2 Test");
	setSize(500, 300);
	//윈도우 창 종료시 프로세스 닫기
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//화면에 출력
	setVisible(true);
	}
}

public class GUITest2_1 {

	public static void main(String[] args) {
		new GUI2();
	}
}
