import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sh.do")
public class Shopping extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1~100������ ¦�� ��
		int sum = 0;
		for (int i = 2; i <= 100; i+=2) {
			sum += i;
		}
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("3218_�ִٿ� : "+ sum);
		out.println("</body>");
		out.println("</html>");
	}

}