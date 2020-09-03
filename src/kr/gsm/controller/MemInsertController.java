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

@WebServlet("/memInsert.me")
public class MemInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		int bun = Integer.parseInt(request.getParameter("bun"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(bun, name, tel, email, addr);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memInsert(vo);
		
	
		PrintWriter out = response.getWriter();
		if(cnt > 0) {
			out.println("OK");
			response.sendRedirect("list.do");
		}else {
			out.println("FAIL");
		}
		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		int age = Integer.parseInt(request.getParameter("age"));
//		
//		MemberVO vo = new MemberVO(id, pwd, age);
//		MemberDAO dao = new MemberDAO();
//		
//		int cnt = dao.memInsert(vo);
//		

	}

}
