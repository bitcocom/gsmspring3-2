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
</head>
<body>
<table>
  <tr>
     <td>번호</td>
     <td>아이디</td>
     <td>패스워드</td>
     <td>이름</td>
     <td>나이</td>
     <td>전화번호</td>
     <td>이메일</td>
  </tr>
  <% for(int i=0;i<list.size();i++){ 
          MemberVO vo=list.get(i);
    %>
     <tr>
     <td><%=vo.getNum()%></td>
     <td><%=vo.getId()%></td>
     <td><%=vo.getPass()%></td>
     <td><%=vo.getName()%></td>
     <td><%=vo.getAge()%></td>
     <td><%=vo.getPhone()%></td>
     <td><%=vo.getEmail()%></td>
     </tr>  
  <%  }  %>
</table>
</body>
</html>