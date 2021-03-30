package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.memberList();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(list.toString());
		//응답화면을 여기서 만들것인가? = Servlet
		//View=>JSP(memberList.jsp)
		//응답을 요청할 JSP파일을 얻어오기
		// 객체바인딩
		request.setAttribute("list", list);
		// forward(포워딩)
		RequestDispatcher rd=request.getRequestDispatcher("member/memberList.jsp");
		rd.forward(request, response); // memberList.jsp(실행)
		
	}
}
