<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="kr.gsm.model.*" %>    
<%
    List<MemberVO> list=(List<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
       function register() {
		  location.href="member/memberRegister.html";
	   }
       function memDel(num){
    	  location.href="/m2/memberDelete.do?num="+num; // get방식
       }
  </script>
</head>
<body>
- 회원리스트-
<table class="table table-bordered table-hover">
  <tr>
     <td>번호</td>
     <td>아이디</td>
     <td>패스워드</td>
     <td>이름</td>
     <td>나이</td>
     <td>전화번호</td>
     <td>이메일</td>
     <td>삭제</td>
  </tr>
  <% for(int i=0;i<list.size();i++){ 
          MemberVO vo=list.get(i);
    %>
     <tr>
     <td><%=vo.getNum()%></td>
     <td><a href="/m2/memberContent.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>
     <td><%=vo.getPass()%></td>
     <td><%=vo.getName()%></td>
     <td><%=vo.getAge()%></td>
     <td><%=vo.getPhone()%></td>
     <td><%=vo.getEmail()%></td>
     <td><input type="button" value="삭제" class="btn btn-warning"  onclick="memDel(<%=vo.getNum()%>)"></td>
     </tr>  
  <%  }  %>
  <tr>
    <td colspan="8" align="right">
      <input type="button"  onclick="register()"  value="회원가입" class="btn btn-primary"/>
    </td>
  </tr>
</table>
</body>
</html>