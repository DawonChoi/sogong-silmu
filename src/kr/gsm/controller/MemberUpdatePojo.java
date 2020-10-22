package kr.gsm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberMyBatisDAO;
import kr.gsm.model.MemberVO;

public class MemberUpdatePojo implements Controller{
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int num = Integer.parseInt(request.getParameter("num"));
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setAddr(addr);
		
		MemberMyBatisDAO dao = new MemberMyBatisDAO();
		int cnt = dao.memUpdate(vo);
		
		String nextPage = null;
		if(cnt > 0) {
			nextPage = "redirect:/list.do";
		}
		
		return nextPage;
	}
}
