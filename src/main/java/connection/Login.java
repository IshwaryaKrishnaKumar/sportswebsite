package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("name");
		String pword = req.getParameter("psw");
		List <Variables>li = new ArrayList();
		li=Dbconnect.demo(id);
		Iterator itr =li.iterator();
		Variables admin = new Variables();
		while(itr.hasNext()) {
			Variables ad=(Variables)itr.next();
			admin.setId(ad.getId());
			admin.setUsername(ad.getUsername());
			admin.setPassword(ad.getPassword());
		}
		if(admin.getId()==(id)&& admin.getUsername().equals(uname) && admin.getPassword().equals(pword)) {
			req.getRequestDispatcher("AdminHome.html").include(req, res);
			System.out.println("login successfully");
		}
		else {
			System.out.println("error");
			req.getRequestDispatcher("Login.html").include(req, res);
			out.println("<script type=\"text/javascript\">");  
			out.println("document.getElementById(\"test\").innerHTML = \"Enter Your Correct Details.....  \"");  
			out.println("</script>");
		}
	}
}
