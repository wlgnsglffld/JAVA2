package chap15_1017;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ActionEvent1 implements ActionListener{
	private JTextArea content;
    private JTextField f_name;

    public ActionEvent1(JTextArea content, JTextField f_name) {
        this.content = content;
        this.f_name = f_name;
    }
	@Override
	public void actionPerformed(java.awt.event.ActionEvent ae) {
		try {
			// 입출력을 위한 예외처리
			// 파일 이름으로 출력 객체 생성.
			String s = f_name.getText();
			FileOutputStream fos = new FileOutputStream(s);
			DataOutputStream dos = new DataOutputStream(fos);
			
			//텍스트 에어리어의 내용을 파일로 출력
			dos.writeUTF(content.getText());
			
			//파일 닫기
			fos.close();
			System.out.println(f_name.getText()+"파일이 생성되었습니다.");
		}
		catch(Exception e){
			
		}
	}
}

class GUI1 extends JFrame{
	//속성으로 텍스트 에어리어와텍스트 필드를 선언.
	private JTextArea content;
	private JTextField f_name;
	
	//생성자
	public GUI1() {
	//텍스트 필드 객체 생성.
    content = new JTextArea("내용을 입력해주세요.", 10, 20);
	//텍스트 에어리어 객체 생성
	f_name = new JTextField("파일명을 입력해주세요.", 20);
	//버튼 객체 생성
	JButton jb = new JButton("파일로 저장");
	
	//컨테이너 생성
	Container ct = getContentPane();
	//배치 관리자 생성 - FlowLayout
	ct.setLayout(new FlowLayout());
	//패널 생성.
	JPanel pl = new JPanel();
	
	//컨테이너
	ct.add(content);
	ct.add(pl);
	
	//패널
	pl.add(f_name);	
	pl.add(jb);
	
	
	
	//컴포넌트에 리스너 등록
	jb.addActionListener(new ActionEvent1(content, f_name));
	
	setTitle("GUI1 Test");
	setSize(500, 300);
	//윈도우 창 종료시 프로세스 닫기
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//화면에 출력
	setVisible(true);
	}
}

public class GUITest1_1 {

	public static void main(String[] args) {
		new GUI1();

	}

}