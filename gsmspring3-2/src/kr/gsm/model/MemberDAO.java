package kr.gsm.model;
// JDBC->myBatis
import java.sql.*;
public class MemberDAO {
   private Connection conn;  // DB연결객체
   private PreparedStatement ps;  //SQL전송객체
   private ResultSet rs; // 결과집합을담는객체
   // 연결동작
   public void getConnect() {
	    String url="jdbc:mysql://localhost:3306/mysql";
	    String user="root";
	    String password="12345";
	    // 드라이버클래스를 메모리에 로딩 :com.mysql.jdbc.Driver	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
   }   
   // 저장동작
   public int memberInsert(MemberVO vo) {
	   getConnect(); // DB연결                                                                                               1 2 3 4 5 6
	   //          불완전한 SQL
	   String SQL="insert into member(id, pass, name, age, phone, email) values(?,?,?,?,?,?)";
	   int cnt=0;
	   try {
		    ps=conn.prepareStatement(SQL); // SQL전송문장 객체생성
		    ps.setString(1, vo.getId());
		    ps.setString(2, vo.getPass());
		    ps.setString(3, vo.getName());
		    ps.setInt(4, vo.getAge());
		    ps.setString(5, vo.getPhone());
		    ps.setString(6, vo.getEmail());
		    cnt=ps.executeUpdate(); // 실행
	    } catch (Exception e) {
		e.printStackTrace();
	   }
	   return cnt;
   }   
}
