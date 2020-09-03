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

@WebServlet("/update")
public class memberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		int num = Integer.parseInt(request.getParameter("num"));
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setAddr(addr);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memUpdate(vo);
		
		if(cnt > 0) {
			response.sendRedirect("list.do");
		}else {
			throw new ServletException("error");
		}
	}

}
