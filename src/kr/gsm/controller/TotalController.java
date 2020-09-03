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
		// Controller����
		// 1. Ŭ���̾�Ʈ�� ��û�� �޴� �۾�
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		// 2. Model�� �����۾�
		MyUtil my = new MyUtil();
		int result = my.totCnt(su1, su2);
		
		// 3. Ŭ���̾�Ʈ���� �����ϴ� �۾�(View=response thing)
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("-----"+su1+"~"+su2+"------");
		out.println("<br>");
		out.println("3218_�ִٿ�: "+result);
		out.println("<br>");
		out.println(my.totCntList(su1, su2));
		out.println("</body>");
		out.println("</html>");
	}

}
