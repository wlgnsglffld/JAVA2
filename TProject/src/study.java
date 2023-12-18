// 학생 정보 테이블 데이터 표현을 위한 클래스
public class study {
	// 컬럼정보에 따른 필드 선언
	private int Number;
	private String Answer;
	private String Question;
	private String AnswerSheet;
	
	// Getter/Setter 메서드
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswerSheet() {
		return AnswerSheet;
	}
	public void setAnswerSheet(String answersheet) {
		AnswerSheet = answersheet;
	}
}