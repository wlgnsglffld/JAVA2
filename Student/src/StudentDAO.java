import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDAO {

	String jdbcUrl = "jdbc:mysql://localhost/studentDB?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
	//
	Connection conn;
	
	String id = "root";  
	String pw = "1234"; 
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	Vector<String> items = null;
	String sql;
	
	// DB연결 메소드
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DB 연결 종료 메소드
	public void closeDB() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	

	// 콤보박스의 학생관리 번호 목록을 위한 벡터 리턴
	public Vector<String> getItems() {
		return items;
	}
	
	// 전체 학생 목록을 가지고 오는 메소드
	public ArrayList<Student> getAll() {
		connectDB();
		sql = "select * from student";
		
		//전체 검색 데이터를 전달하기 위한 ArrayList
		ArrayList<Student> datas = new ArrayList<Student>();
		
		// 학생 관리 번호 콤보박스 데이터를 위한 벡터 초기화
		items = new Vector<String>();
		items.add("연번선택");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			// 검색된 데이터수 만큼 루프를 돌며 Student 객체를 만들고 이를 다시 ArrayList 에 추가함.
			while(rs.next()) {
				Student s = new Student();
				s.setNumber(rs.getInt("number"));
				s.setDept(rs.getString("dept"));
				s.setStudentID(rs.getInt("studentID"));
				s.setGrade(rs.getInt("Grade"));
				s.setName(rs.getString("Name"));
				s.setPhone(rs.getString("Phone"));
				datas.add(s);
				items.add(String.valueOf(rs.getInt("number")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeDB();
		}
		return datas;
	}
	
	// 새로운 학생을 등록하는 메소드
	public boolean insertStudent(Student student) {
		connectDB();
		
		// number은 자동증가 컬럼이므로 직접 입력하지 않는다.
		sql = "insert into student(dept,studentID,grade,name,phone) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getDept());
			pstmt.setInt(2, student.getStudentID());
			pstmt.setInt(3, student.getGrade());
			pstmt.setString(4, student.getName());
			pstmt.setString(5, student.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeDB();
		}
		return true;
	}
	
	// 선택한 학생 관리 번호에 해당하는 학생 정보를 가지고 오는 메소드
	public Student selectStudent(int number) {
		connectDB();
		sql = "select * from student where number=?";
		Student s = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			rs.next();
			s = new Student();
			s.setNumber(rs.getInt("number"));
			s.setDept(rs.getString("dept"));
			s.setStudentID(rs.getInt("studentID"));
			s.setGrade(rs.getInt("Grade"));
			s.setName(rs.getString("Name"));
			s.setPhone(rs.getString("Phone"));
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeDB();
		}
		return s;
	}
	
	// 수정한 정보로 학생 정보를 업데이트 하는 메소드
	public boolean updatestudent(Student student) {
		connectDB();
		sql = "update student set dept=?, studentID=?, grade=?, name=?, phone=? where number=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getDept());
			pstmt.setInt(2, student.getStudentID());
			pstmt.setInt(3, student.getGrade());
			pstmt.setString(4, student.getName());
			pstmt.setString(5, student.getPhone());
			pstmt.setInt(6, student.getNumber());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeDB();
		}
		return true;
	}
	
	// 선택한 학생을 삭제하는 메소드
	public boolean deletestudent(int number) {
		connectDB();
		sql = "delete from student where number=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeDB();
		}
		return true;
	}
	
	// 학과별 정렬 메소드
	public Student DeptSortStudent(Student student) {
		connectDB();
		
		// 오름차순
		sql = "select * from student order by Dept, grade asc;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeDB();
		}
		return null;
	}


}