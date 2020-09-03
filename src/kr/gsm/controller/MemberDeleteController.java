package kr.gsm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.gsm.model.*;
@WebServlet("/delete")
public class MemberDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memDelete(num);
		if(cnt > 0) {
			response.sendRedirect("list.do");
		}else {
			throw new ServletException("fail");
		}
		
	}

}
