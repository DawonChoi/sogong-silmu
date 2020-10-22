package kr.gsm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberMyBatisDAO;
import kr.gsm.model.MemberVO;

public class MemberContentPojo implements Controller{
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int num = Integer.parseInt(request.getParameter("num"));
		MemberMyBatisDAO dao = new MemberMyBatisDAO();
		MemberVO vo = dao.memContent(num);
		
		request.setAttribute("vo", vo);
		
		String nextPage = "member/memberContent.jsp";
		return nextPage;
	}
}
