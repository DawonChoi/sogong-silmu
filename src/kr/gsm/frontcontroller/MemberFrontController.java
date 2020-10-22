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

import kr.gsm.controller.Controller;
import kr.gsm.controller.HandlerMapping;
import kr.gsm.controller.MemberContentPojo;
import kr.gsm.controller.MemberDeletePojo;
import kr.gsm.controller.MemberInsertPojo;
import kr.gsm.controller.MemberListPojo;
import kr.gsm.controller.MemberUpdatePojo;
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
		
		String nextPage = null;
		Controller pojo = null;
		
		HandlerMapping mapping = new HandlerMapping();
		pojo = mapping.getController(cmd);
		nextPage = pojo.requestHandler(request, response);
		
		System.out.println(nextPage);
		
		if(nextPage!=null) {
			if(nextPage.indexOf("redirect:/")!=-1) {
				response.sendRedirect(nextPage.split("/")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextPage);
				rd.forward(request, response);
			}
		}
		
	}
}
