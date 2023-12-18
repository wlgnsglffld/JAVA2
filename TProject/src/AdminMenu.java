import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//데이터베이스에 문제와 설명을 추가하는 판넬
class addPanel extends JPanel implements ActionListener{
	JTextArea detail;
	JTextField word;
	JLabel msg = new JLabel();
	study study = new study();;	// study 클래스의 객체 생성
	StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성
	public addPanel() {
		//JTextArea, JTextField 생성
		detail = new JTextArea("추가할 단어의 뜻을 적어주세요.!",25, 60);
		word = new JTextField(25);
				
		// 메세지 영역
		msg.setText(" 추가할 단어를 적어주세요.!!");
		msg.setEnabled(false);
		
		//버튼 생성
		JButton add = new JButton("추가");
		
        // JTextArea에 자동 줄바꿈 설정
        detail.setLineWrap(true);
        detail.setWrapStyleWord(true);
        
		
        //컴포넌트를 판넬에 추가
		add(msg);
		add(word);
		add(detail);
		add(add);
		
		//버튼에 이벤트리스너 등록
		add.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//문제와 설명을 가져와 study객체에 저장
		study.setQuestion(detail.getText());
		study.setAnswer(word.getText());
		
		//데이터베이스에 문제와 설명을 등록
		if(Sdao.insertStudy(study)) {
			msg.setText("문제를 등록했습니다.!!");
		}
		else {
			msg.setText("문제 등록이 실패 했습니다.!!");
		}   		
	}
}

//데이터베이스에 문제와 설명을 삭제하는 판넬
class delPanel extends JPanel implements ActionListener{
	JTextArea detail;
	JTextField word;
	JLabel msg = new JLabel();
	JButton search;
	JButton del;
	StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성
	public delPanel() {
		//JTextField,JTextArea생성
		detail = new JTextArea("단어 설명",25, 60);
		word = new JTextField(25);
		// 메세지 영역
		msg.setText(" 삭제할 단어를 입력하세요.!!");
		msg.setEnabled(false);
		//버튼 생성
		search = new JButton("검색");
		del = new JButton("삭제");
		
		//컴포넌트를 판넬에 추가
		add(msg);
		add(word);
		add(search);
		add(detail);
		add(del);
		
        // JTextArea에 자동 줄바꿈 설정
        detail.setLineWrap(true);
        detail.setWrapStyleWord(true);
		
        //버튼에 이벤트리스너 등록
		search.addActionListener(this);
		del.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	//Answer값을 가져오는 객체와 문제를 검색하는 객체생성
    	String Answer = word.getText();
        String Question = Sdao.searchStudy(Answer);
        
    	if(obj == search) {	//검색
            if (Question != null) {	//question출력
                detail.setText(Question);
            } else {	//값이 존재하지 않음
                detail.setText("일치하는 데이터를 찾을 수 없습니다.");
            }
            
    	}else if(obj == del) {	//삭제
    		if(Sdao.deleteStudy(Answer)) {	//데이터베이스에 저장된 값을 삭제
    			detail.setText("문제가 삭제되었습니다.!!");	//반환값이 true일때
    		}
    		else {
    			detail.setText("문제가 삭제되지 않았습니다.!!");	//반환값이 false일때	    			    			
    		}  
    	}
    	
	}
}

//데이터베이스에 저장된 문제를 수정하는 판넬
class corrPanel extends JPanel implements ActionListener{
	JTextArea detail;
	JTextField word;
	JLabel msg = new JLabel();
	JButton search;
	JButton corr;
	StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성
	study study = new study();	// study 클래스의 객체 생성
	public corrPanel() {
		//JTextField, JTextArea 생성
		detail = new JTextArea("단어 설명",25, 60);
		word = new JTextField(25);
		
		// 메세지 영역
		msg.setText(" 수정할 단어를 입력하세요.!!");
		msg.setEnabled(false);
		
		//버튼 생성
		search = new JButton("검색");
		corr = new JButton("수정");
		
		//판넬에 컴포넌트를 추가
		add(msg);
		add(word);
		add(search);
		add(detail);
		add(corr);
		
        // JTextArea에 자동 줄바꿈 설정
        detail.setLineWrap(true);
        detail.setWrapStyleWord(true);
		
        //버튼에 이벤트리스너 등록
		search.addActionListener(this);
		corr.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//Answer값을 가져오는 객체와 문제를 검색하는 객체 생성
    	String Answer = word.getText();
        String Question = Sdao.searchStudy(Answer);
        
    	if(obj == search) {	//검색
            if (Question != null) {	//question출력
                detail.setText(Question);
            } else {	//값이 존재하지 않음
                detail.setText("일치하는 데이터를 찾을 수 없습니다.");
            }
            
    	}else if(obj == corr) {	//수정
    		//수정할 정답과 문제를 study객체에 저장
    		study.setAnswer(word.getText());
    		study.setQuestion(detail.getText());
    		if(Sdao.updateStudy(study)) {	//study에 저장된 정답과 문제를 update로 수정
				detail.setText("문제 정보를 수정했습니다.!!");	//반환값이 true
			}
    		else {
    			detail.setText("문제 정보 수정에 실패 했습니다.!!");	//반환값이 false
    		}
    	}
		
	}
}

//데이터베이스에 저장된 문제를 검색하는 판넬
class searchPanel extends JPanel implements ActionListener{
	JTextArea question;
	JTextField answer;
	JLabel msg = new JLabel();
	StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성
	public searchPanel() {
		//JTextField, JTextArea생성
		answer = new JTextField(20);
		question = new JTextArea("검색한 단어의 뜻 ", 25, 60);
		
		// 메세지 영역
		msg.setText(" 검색할 단어를 입력하세요.!!");
		msg.setEnabled(false);
		
		//버튼 생성
		JButton search = new JButton("검색");
		
        // JTextArea에 자동 줄바꿈 설정
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
		
        //컴포넌트를 판넬에 추가
        add(msg);
		add(answer);
		add(search);
		add(question);
		
		//버튼에 이벤트리스너 등록
		search.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Answer값을 가져오는 객체와 문제를 검색하는 객체 생성
		String Answer = answer.getText();
        String Question = Sdao.searchStudy(Answer);

        if (Question != null) {
            question.setText(Question);	//question출력
        } else {
            question.setText("일치하는 데이터를 찾을 수 없습니다.");
        }
	}
}

class Admin extends JFrame{
   	// 데이터베이스 연동 클래스 인스턴스 생성
	StudyDAO Sdao = new StudyDAO();
	public Admin() {
		//컨테이너 생쉉
		Container ct = getContentPane();
		
		//기능 버튼을 모아두는 탭바 생성
		JTabbedPane tab = new JTabbedPane();
		//판넬 생성
		addPanel add = new addPanel();
		delPanel del = new delPanel();
		corrPanel corr = new corrPanel();
		searchPanel search = new searchPanel();
		
		//tab에 판넬을 추가
		tab.add("단어 추가", add);
		tab.add("단어 삭제", del);
		tab.add("단어 수정", corr);
		tab.add("검색", search);
		
		//컨테이너에 tab추가
		ct.add(tab);
		
		//화면에 보이도록
		setTitle("관리자 메뉴");
		setSize(700,550);
		
		//화면에 출력
		setVisible(true);
	}
}

public class AdminMenu {

	public static void main(String[] args) {
		new Admin();
	}

	public static void setVisible(boolean b) {
		new Admin();
		
	}

}
