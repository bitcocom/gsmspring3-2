package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 1. 파라메터수집(VO,DTO)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name"); //한글
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setPhone(phone);
		vo.setEmail(email);
		// Database 저장 : MemberDAO
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberInsert(vo);
		PrintWriter out=response.getWriter();
		if(cnt>0) {
			// 성공->리스트보기 요청으로...
			//out.println("insert success~~");
			// redirect기법
			response.sendRedirect("/m2/memberList.do");
		}else {
			// 실패
			throw new ServletException("error");
		}
	}
}