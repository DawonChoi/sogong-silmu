package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MyUtil;

@WebServlet("/tot.do" )
public class TotalController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Controller역할
		// 1. 클라이언트의 요청을 받는 작업
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		// 2. Model과 연동작업
		MyUtil my = new MyUtil();
		int result = my.totCnt(su1, su2);
		
		// 3. 클라이언트에게 응답하는 작업(View=response thing)
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("-----"+su1+"~"+su2+"------");
		out.println("<br>");
		out.println("3218_최다원: "+result);
		out.println("<br>");
		out.println(my.totCntList(su1, su2));
		out.println("</body>");
		out.println("</html>");
	}

}
