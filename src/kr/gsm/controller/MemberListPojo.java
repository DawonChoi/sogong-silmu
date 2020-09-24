package kr.gsm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

public class MemberListPojo {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getAllList();
		
		request.setAttribute("list", list);
		String nextPage="member/memberList.jsp";
		return nextPage;
		}
	
}

