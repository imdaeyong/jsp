package sub2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException { //서블릿이 최초 1번만 실행되는 메서드
		System.out.println("HelloServlet init 실행...");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req,resp);
	}
	
	public void requestProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //위의거랑 똑같이! get을 요청하나 post를 요청하나 똑같은 출력
		
		//HTML 출력
		resp.setContentType("text/html; charset= utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>HelloServlet</title>");
		out.println("<meta charset='UTF-8'/>	");
		
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>Hello Servlet!!!!!</h1>");
		out.println("</body>");
		
		
		out.println("<html>");
		
	}

}
