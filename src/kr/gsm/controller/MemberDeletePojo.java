package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

public class MemberDeletePojo implements Controller{
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memDelete(num);
		
		String nextPage = null;
		if(cnt > 0) {
			nextPage = "redirect:/list.do";
		}
		
		return nextPage;
	}
}
