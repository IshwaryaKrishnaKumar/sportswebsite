package connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/delete")
public class AdminDelete extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		Dbconnect ins= new Dbconnect();
		int status=ins.delete(id);
		if(status>0) {
			System.out.println("sucess");
			// for redirection purpose
			req.getRequestDispatcher("AdminEmployee").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"test\").innerHTML = \"succesfully deleted\"");  
			out.println("</script>");
		}else {
			System.out.println("error");
		}
	}
}
