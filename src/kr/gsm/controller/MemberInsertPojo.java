package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberMyBatisDAO;
import kr.gsm.model.MemberVO;

public class MemberInsertPojo implements Controller{
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("euc-kr");
		int bun = Integer.parseInt(request.getParameter("bun"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(bun, name, tel, email, addr);
		MemberMyBatisDAO dao = new MemberMyBatisDAO();
		int cnt = dao.memInsert(vo);
		String nextPage = null;
		if(cnt > 0) {
			nextPage="redirect:/list.do";
		}
		
			return nextPage;
		}
}
