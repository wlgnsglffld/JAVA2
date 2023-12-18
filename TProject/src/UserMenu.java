import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class learnPanel extends JPanel implements ActionListener{
    JTextField answer;
	JLabel msg = new JLabel();
    JTextArea question;
    JButton next;
    JButton back;
    int number = 1;
    StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성    
    study study = Sdao.getDataFromDatabase(number);	// 데이터베이스에서 새로운 레코드 가져오기
    public learnPanel() {
    	//JTextFeild, JTextArea 생성
        answer = new JTextField(study.getAnswer(), 30);
        question = new JTextArea(study.getQuestion(), 25, 60);

		// 메세지 영역
		msg.setText(" 정보 처리 기사 단어.!!");
		msg.setEnabled(false);
		
        // JTextArea에 자동 줄바꿈 설정
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        
        //버튼 생성
        back = new JButton("이전");
        next = new JButton("다음");

        //컴포넌트를 판넬에 추가
		add(msg);
        add(answer);
        add(question);
        add(back);
        add(next);
        
        //버튼에 이벤트리스너 등록
        back.addActionListener(this);
        next.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
	    if (obj == next && number < Sdao.getMaxNumber()) {	//다음
	        number++;
	    } else if (obj == back && number > 1) {	//이전
	        number--;
	    }
	
		// 데이터베이스에서 새로운 레코드 가져오기
	    study = Sdao.getDataFromDatabase(number);
	    
	    // 가져온 레코드의 값으로 answer와 question 업데이트
	    answer.setText(study.getAnswer());
	    question.setText(study.getQuestion());
	}
}

class quizPanel extends JPanel implements ActionListener{
	JTextArea question;
    JTextArea answersheet;
    JTextField answer;
	JLabel msg = new JLabel();
    JButton accept;
    int i=0;
    study study;	
    StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성 
    HashSet<Integer> usedNumbers = new HashSet<>();	//중복된 값을 제거하는 객체생성
    public quizPanel() {
    	//랜덤 정수를 가져오는 메서드
        study = getRandomStudy();

        //JTextField, JTextArea 생성
        question = new JTextArea(study.getQuestion(), 25, 40);
        answersheet = new JTextArea(25, 20);
        
		// 메세지 영역
		msg.setText(" 문제 정답을 입력해주세요.!!");
		msg.setEnabled(false);
        
        //버튼 생성
        answer = new JTextField(20);
        accept = new JButton("확인");

        // JTextArea에 자동 줄바꿈 설정
        question.setLineWrap(true);
        question.setWrapStyleWord(true);

        //컴포넌트를 판넬에 추가
        add(question);
        add(answersheet);
        add(msg);
        add(answer);
        add(accept);

        //버튼에 이벤트 리스너 등록
        accept.addActionListener(this);
    }

    //중복되지 않는 랜덤한 문제를 가져오는 메서드
	private int questionNumber = 0;//가져올 문제 번호
    private study getRandomStudy() {
        Random r = new Random();
        //데이터베이스에서 문제 개수의 최대값을 가져오는 메서드
    	int maxNumber = Sdao.getMaxNumber();
        int newNumber;
        do {
            newNumber = r.nextInt(maxNumber) + 1;	
        } while (usedNumbers.contains(newNumber));	//새로운 번호를 가져올때까지 반복

        usedNumbers.add(newNumber);	//Hashset에 새로운 번호 추가

        // 새로운 문제를 가져오고 "문제번호@"를 추가하여 반환
        study newStudy = Sdao.getDataFromDatabase(newNumber);
        questionNumber++;
        newStudy.setQuestion("☆문제" + questionNumber +"번☆\n" + newStudy.getQuestion());

        return newStudy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == accept && usedNumbers.size() <= 10) {	//확인
        	//사용자의 답과 정답을 가져오는 객체
            String userAnswer = answer.getText();
            String correctAnswer = study.getAnswer();

            //answersheet에 사용자의 답 등록
            answersheet.append(questionNumber + "번 문제 답: " + userAnswer + "\n");

            if (userAnswer.equals(correctAnswer)) {	//정답
                answersheet.append("O\n");
                i++;

            } else {	//오답
                answersheet.append("X\n");
                Sdao.incorrQuestion(study);	//데이터베이스에 오답을 추가	
            }
            
            //다음 문제를 가져옴
            study = getRandomStudy();
            
            if(usedNumbers.size() <= 10) {	//다음 문제 출력과 답안지 초기화
            question.setText(study.getQuestion());
            answer.setText("");
            
            }else {
                question.setText("10 문제 중" + i + "개 맞았습니다.  \n 오답 노트 에서 틀린문제 확인하세요.");	//정답률 출력
            }
        } 
    }
}

//오답문제를 출력하는 판넬
class incorrPanel extends JPanel implements ActionListener{
	JTextField answer;
	JTextArea question;
	JLabel msg = new JLabel();
	JButton back;
	JButton next;
    study study;
    StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성 
    int number = 0;
	public incorrPanel() {
		//JTextField, JTextArea 생성
		answer = new JTextField(30);
		question = new JTextArea("설명", 25, 60);
		
		// 메세지 영역
		msg.setText(" 틀린 문제 정답은.!!");
		msg.setEnabled(false);
		
		//버튼 생성
		back = new JButton("이전");
		next = new JButton("다음");
		
		// JTextArea에 자동 줄바꿈 설정
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        
        //컴포넌트를 판넬에 추가
        add(msg);
		add(answer);
		add(question);
		add(back);
		add(next);
		
		//버튼에 이벤트리스너 등록
		back.addActionListener(this);
		next.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == next) {	//다음
	        int maxNumber = Sdao.getMaxNumber_incorr();	//오답의 최대 갯수
	        if (number < maxNumber) {
	            number++;
	        }
	    } else if (obj == back) {	//이전
	        if (number > 1) {
	            number--;
	        }
	    }
		
		//데이터베이스에서 새로운 레코드 가져오기
		study = Sdao.getDataFromDatabase_incorr(number); 
		
	     // 가져온 레코드의 값으로 answer와 question 업데이트
	     answer.setText(study.getAnswer());
	     question.setText(study.getQuestion());
	}
}

//데이터베이스에 저장된 문제를 검색하는 판넬
class search1Panel extends JPanel implements ActionListener{
	JTextArea question;
	JTextField answer;
	JLabel msg = new JLabel();
	study study;
	StudyDAO Sdao = new StudyDAO();	// 데이터베이스 연동 클래스 인스턴스 생성 
	public search1Panel() {
		//JTextField,JTextArea 생성
		answer = new JTextField(30);
		question = new JTextArea("설명", 25, 60);
		
		// 메세지 영역
		msg.setText(" 검색할 단어를 입력해주세요.!!");
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

        if (Question != null) {	//question 출력
            question.setText(Question);
        } else {
            question.setText("일치하는 데이터를 찾을 수 없습니다.");
        }
	}
}
class User extends JFrame{
	public User() {
		//컨테이너 생쉉
		Container ct = getContentPane();
		
		//기능 버튼을 모아두는 탭바 생성
		JTabbedPane tab = new JTabbedPane();
		
		//패널 생성 및 추가
		learnPanel learn = new learnPanel();
		quizPanel quiz = new quizPanel();
		incorrPanel score = new incorrPanel();
		search1Panel search = new search1Panel();
		
		//tab에 판넬을 추가
		tab.add("학습 모드", learn);
		tab.add("퀴즈 모드", quiz);
		tab.add("오답노트", score);
		tab.add("검색", search);
		
		//컨테이너에 tab추가
		ct.add(tab);
		
		//화면에 보이도록
		setTitle("사용자 메뉴");
		setSize(700,550);

		//화면에 출력
		setVisible(true);		
	}
}

public class UserMenu {

	public static void main(String[] args) {
		new User();

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		new User();
	}

}
