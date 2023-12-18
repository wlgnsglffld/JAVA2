import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	public static void main(String[] args) {
		Connection conn;
		String url = "jdbc:mysql://localhost:3306/dbstudent?serverTimezone=UTC";
		// 데이터베이스 URL           localhost 또는 127.0.0.1 로 설정.
		// connector 5.1.x 이후버전부터 KST타임존을 인식하지 못하는 이슈가 있어 serverTimezone 추가.
		// 만약 한글 깨짐 현상이 있다면 useUnicode=true&characterEncoding=UTF8 추가 설정. 
		
		String id = "root";   // DB에 로그인할 ID
		String pw = "1234";   // MYSQL 설정 시 입력한 PASSWORD

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // JDBC 드라이버 로드.
			
			conn = DriverManager.getConnection(url, id, pw);  // 데이터베이스 연결.
			// DriverManager 자바 어플리케이션을 JDBC드라이버에 연결시켜주는 클래스. 
			// getConnection() 메소로 DB에 연결하여 Connection 객체 반환.
			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
}

