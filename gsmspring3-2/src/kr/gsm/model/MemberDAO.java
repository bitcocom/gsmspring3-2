package kr.gsm.model;
// JDBC->myBatis
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
   //회원전체리스트 : List<MemberVO> 
   public List<MemberVO> memberList() {
	   getConnect();
	   String SQL="select * from member order by id asc"; // ?
	   List<MemberVO> list=new ArrayList<MemberVO>();
	   try {
		    ps=conn.prepareStatement(SQL);
		    rs=ps.executeQuery(); // select SQL
		    while(rs.next()) {
		       int num=rs.getInt("num");
		       String id=rs.getString("id");
		       String pass=rs.getString("pass");
		       String name=rs.getString("name");
		       int age=rs.getInt("age");
		       String phone=rs.getString("phone");
		       String email=rs.getString("email");
		       MemberVO vo=new MemberVO();// 묶고
		       vo.setNum(num);
		       vo.setId(id);
		       vo.setPass(pass);
		       vo.setName(name);
		       vo.setAge(age);
		       vo.setPhone(phone);
		       vo.setEmail(email);
		       list.add(vo);//담고
		    }
	    } catch (Exception e) {
		  e.printStackTrace();
	   }
	   return list;
   }
}
