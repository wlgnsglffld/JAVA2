// 학생 정보 테이블 데이터 표현을 위한 클래스
public class Student {
	
	// 컬럼정보에 따른 필드 선언
	private int Number;
	private String Dept;
	private int studentID;
	private int Grade;
	private String Name;
	private String Phone;
	
	// Getter/Setter 메서드
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
}