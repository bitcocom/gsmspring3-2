package kr.gsm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			                                                throws ServletException, IOException {
		// 1. 파라메터 수집
		int num=Integer.parseInt(request.getParameter("num"));
		// 2. Model과 연동
		MemberDAO dao=new MemberDAO();
		
	}
}
