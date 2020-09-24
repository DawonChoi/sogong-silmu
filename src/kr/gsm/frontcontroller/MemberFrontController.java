package kr.gsm.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.controller.MemberInsertPojo;
import kr.gsm.controller.MemberListPojo;
import kr.gsm.model.*;
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do
		// insert.do
		String reqUrl=request.getRequestURI();
		String cpath=request.getContextPath(); // /m
		System.out.println(reqUrl.substring(cpath.length()));
		String cmd=reqUrl.substring(cpath.length());
		
		PrintWriter out = response.getWriter();
		
		if(cmd.equals("/list.do")) {
			MemberListPojo pojo = new MemberListPojo();
			String nextPage = pojo.requestHandler(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if(cmd.equals("/insert.do")) {
			MemberInsertPojo pojo = new MemberInsertPojo();
			String nextPage = pojo.requestHandler(request, response);
			
			response.sendRedirect(nextPage);
		}else if(cmd.equals("/delete.do")) {
			int num=Integer.parseInt(request.getParameter("num"));
			MemberDAO dao=new MemberDAO();
			int cnt=dao.memDelete(num);
			
			if(cnt > 0) {
				response.sendRedirect("list.do");
			}else {
				throw new ServletException("fail");
			}
		}else if(cmd.equals("/content.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.memContent(num);
			
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("/update.do")) {
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
}
