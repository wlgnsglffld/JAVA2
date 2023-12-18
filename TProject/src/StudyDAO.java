import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudyDAO {
		String jdbcUrl = "jdbc:mysql://localhost/dbstudy?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
		
		Connection conn;
		
		String id = "root";  
		String pw = "1234"; 
		
		PreparedStatement pstmt;
		PreparedStatement pm;
		ResultSet rs;

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
		
		// 새로운 문제를 등록하는 메소드
	    public boolean insertStudy(study study) {
	        // 데이터베이스 연결
	        connectDB();

	        // 문제을 삽입하는 SQL 쿼리
	        sql = "insert into study(answer, question) values(?,?)";
	        try {
	            // PreparedStatement를 준비
	            pstmt = conn.prepareStatement(sql);
	            
	            // PreparedStatement에 파라미터 설정
	            pstmt.setString(1, study.getAnswer());
	            pstmt.setString(2, study.getQuestion());
	            
	            // 업데이트 실행
	            pstmt.executeUpdate();
	            
	            //변수 생성 및 실행
	            pm = conn.prepareStatement("SET @num := 0");
	            pm.executeUpdate();
	            
	            //변수0을 시작으로 연번 초기화
	            pm = conn.prepareStatement("UPDATE study SET number = @num := @num + 1");
	            
	            pm.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	            
	        } finally {
	            // 데이터베이스 연결 종료
	            closeDB();
	            
	        }
	        // 등록이 성공하면 true 반환
	        return true;
	    }
	    
	    // 선택한 문제를 삭제하는 메소드
		public boolean deleteStudy(String Answer) {
			//데이터베이스 연결
			connectDB();
			
			//문제를 삭제하는 SQL쿼리
			sql = "delete from study where answer=?";
			try {
				// PreparedStatement를 준비
				pstmt = conn.prepareStatement(sql);
				
				// PreparedStatement에 파라미터 설정
				pstmt.setString(1, Answer);
				
				// 업데이트 실행
	            pstmt.executeUpdate();
	            
	            //변수 생성 및 실행
	            pm = conn.prepareStatement("SET @num := 0");
	            pm.executeUpdate();
	            
	            //변수0을 시작으로 연번 초기화
	            pm = conn.prepareStatement("UPDATE study SET number = @num := @num + 1");
	            pm.executeUpdate();
	            
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
				
			}
			finally {
				 // 데이터베이스 연결 종료
				closeDB();
				
			}
			//삭제가 성공하면 true 반환
			return true;
		}
		
		// 수정한 정보로 문제를 업데이트 하는 메소드
		public boolean updateStudy(study study) {
			//데이터베이스 연결
			connectDB();
			
			//문제 정보를 수정하는 SQL쿼리
			sql = "update study set question=? where answer=?";
			try {
				// PreparedStatement를 준비
				pstmt = conn.prepareStatement(sql);
				
				// PreparedStatement에 파라미터 설정
				pstmt.setString(1, study.getQuestion());
				pstmt.setString(2, study.getAnswer());
				
				// 업데이트 실행
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				//데이터베이스 연결 종료
				closeDB();
			}
			//수정이 성공하면 true반환
			return true;
		}
	    
	    // 문제 검색 메소드
	    public String searchStudy(String Answer) {
	        // 데이터베이스 연결
	        connectDB();

	        // 결과로 받을 question 값
	        String question = null;

	        try {
	            // 문제를 검색하는 SQL 쿼리
	            sql = "select question from study where answer=?";

	            // PreparedStatement를 준비
	            pstmt = conn.prepareStatement(sql);

	            // PreparedStatement에 파라미터 설정
	            pstmt.setString(1, Answer);
	            rs = pstmt.executeQuery();

	            // 결과 처리
	            if (rs.next()) {
	                // 결과가 있다면 해당 question 값을 가져옴
	                question = rs.getString("question");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // 데이터베이스 연결 종료
	            closeDB();
	        }

	        return question;
	    }

	    //study 테이블의 최대값을 가져오는 메소드
	    public int getMaxNumber() {
	    	//데이터베이스 연결
	        connectDB();
	        
	        //결과를 받을 변수 등록
	        int maxNumber = 0;

	        try {
	        	//최대값을 받는 SQL쿼리 
	            String sql = "select max(number) as maxnumber from study";
	            
	            // PreparedStatement를 준비
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            //결과 처리
	            if (rs.next()) {
	            	//결과가 있다면 최대값을 가져옴
	                maxNumber = rs.getInt("maxnumber");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	//데이터베이스 연결 종료
	            closeDB();
	        }

	        return maxNumber;
	    }
	    
	    //정답과 문제를 가져오는 메소드
	    public study getDataFromDatabase(int number) {
	    	//데이터베이스 연결
	        connectDB();

	        //결과를 저장할 객체 생성
	        study studyDTO = new study();

	           try {
	        	   //문제를 가져오는 SQL쿼리
	               sql = "select answer, question from study where number = ?";
	               
	               // PreparedStatement를 준비
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setInt(1, number);
	               rs = pstmt.executeQuery();

	               //결과 처리
	               if (rs.next()) {
	            	   //결과가 있다면 answer와 question을 가져옴
	                   studyDTO.setAnswer(rs.getString("answer"));
	                   studyDTO.setQuestion(rs.getString("question"));
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           } finally {
	        	   //데이터베이스 연결 종료
	               closeDB();
	           }

	           return studyDTO;
	       }

	    //오답문제의 최대값을 가져오는 메소드
	    public int getMaxNumber_incorr() {
	    	//데이터베이스 연결
	        connectDB();
	        
	        //결과를 받을 변수 등록
	        int maxNumber = 0;

	        try {
	        	//최대값을 가져오는 SQL쿼리
	            String sql = "select max(number) as maxnumber from incorr";
	            
	            // PreparedStatement를 준비
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            //결과 처리
	            if (rs.next()) {
	            	//결과가 있다면 최대값을 가져옴
	                maxNumber = rs.getInt("maxnumber");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	//데이터베이스 연결 종료
	            closeDB();
	        }

	        return maxNumber;
	    }
	    
	    //틀린 문제를 테이블에 삽입하는 메소드
	    public boolean incorrQuestion(study study) {
	    	// 데이터베이스 연결
	        connectDB();

	        // 오답을 삽입하는 SQL 쿼리
	        sql = "insert into incorr(answer, question) values(?,?)";
	        try {
	            // PreparedStatement를 준비
	            pstmt = conn.prepareStatement(sql);
	           
	            // PreparedStatement에 파라미터 설정
	            pstmt.setString(1, study.getAnswer());
	            pstmt.setString(2, study.getQuestion());
	            
	            //// 업데이트 실행
	            pstmt.executeUpdate();
	            
	            //변수 생성 및 초기화
	            pm = conn.prepareStatement("SET @num := 0");
	            pm.executeUpdate();
	            
	            //변수 0을 시작으로 연변 초기화
	            pm = conn.prepareStatement("UPDATE incorr SET number = @num := @num + 1");
	            pm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            // 데이터베이스 연결 종료
	            closeDB();
	        }
	        // 등록이 성공하면 true 반환
	        return true;
	    }
	    
	    //오답의 정답과 문제를 가져오는 메소드
	    public study getDataFromDatabase_incorr(int number) {
	    	//데이터베이스 연결
	    	connectDB();

	    	//결과를 저장할 객체 생성
	    	study studyDTO = new study();

	           try {
	        	   //오답의 정답과 문제를 가져오는 SQL쿼리
	               sql = "select answer, question from incorr where number = ?";
	               
	               // PreparedStatement에 파라미터 설정
	               pstmt = conn.prepareStatement(sql);
	               
	               // PreparedStatement에 파라미터 설정
	               pstmt.setInt(1, number);
	               rs = pstmt.executeQuery();

	               //결과 처리
	               if (rs.next()) {
	            	   //결과가 있다면 정답과 문제를 가져옴
	                   studyDTO.setAnswer(rs.getString("answer"));
	                   studyDTO.setQuestion(rs.getString("question"));
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
	           } finally {
	        	   //데이터베이스 연결 종료
	               closeDB();
	           }

	           return studyDTO;
	       }
	    
	    //incorr테이블의 값 초기화
	    public void resetIncorr() {
	    	//데이터베이스 연결
	    	connectDB();
	    	
	    	try {
	    		//incorr테이블을 초기화하는 SQL쿼리
               sql = "delete from incorr";
               
               // PreparedStatement에 파라미터 설정
               pstmt = conn.prepareStatement(sql);
               
               // 업데이트 실행
               pstmt.executeUpdate();
	    		} catch (SQLException e) {
	               e.printStackTrace();
	           } finally {
	        	   //데이터베이스 연결 종료
	               closeDB();
	           }
	    }
	    
}
