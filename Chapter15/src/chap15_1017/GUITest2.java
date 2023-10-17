package chap15_1017;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI2 extends JFrame implements ActionListener{
	//속성으로 텍스트 에어리어와 텍스트 필드를 선언.
	private JTextArea contents;
	private	JTextField f_name;
	//생성자
public GUI2() {
	//여러줄 텍스트 객체 생성 - 글 내용 출력
	contents = new JTextArea(10,20);
	//한줄 텍스트 객체 생성. - 파일 저장명 입력
	f_name = new JTextField("파일 이름을 입력하세요",20);
	//버튼 객체 생성 - 저장 버튼
	JButton jb = new JButton("파일 읽어오기");
	// 텍스트 에어리어 수정 불가.
	contents.setEditable(false);
	//컨테이너 생성.
	Container ct = getContentPane();
	// FlowLayout 설정.
	ct.setLayout(new FlowLayout());
	// 패널 생성.
	JPanel p1 = new JPanel();
	
	//판넬에 텍스트 필드 추가
	p1.add(f_name);
	//판넬에 버튼 추가
	p1.add(jb);
	
	//컨테이너에 판넬 추가
	ct.add(p1);
	//컨테이너에 텍스트 에어리어 추가
	ct.add(contents);
	
	
	
	//3. 이벤트 받아들일 버튼에 리스너 등록
	jb.addActionListener(this);
	
	
	//화면 크기, 보이기, 타이틀 
	setTitle("GUI Test2");
	setSize(500,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	try {
		//파일 이름으로 입력 객체 생성
		String s =f_name.getText();
		FileInputStream fis = new FileInputStream(s);
		DataInputStream dis = new DataInputStream(fis);
		
		//파일의 내용을 읽어와서 텍스트 에어리어의 내용으로 설정.
		contents.setText(dis.readUTF());
		//파일 닫기
		fis.close();
		System.out.println(s+"파일을 읽어왔습니다.");
	}
	catch(Exception e) {
		System.out.println("파일이 존재하지 않습니다.");
	}
	
}

}
public class GUITest2 {
	public static void main(String[] args) {
		new GUI2();

	}

}