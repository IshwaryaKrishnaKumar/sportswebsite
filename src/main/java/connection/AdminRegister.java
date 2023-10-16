package connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")

public class AdminRegister extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		int rid=Integer.parseInt(req.getParameter("id"));
		String rname= req.getParameter("name");
		String rpassword = req.getParameter("psw");
		
		Variables re =new Variables();
		re.setId(rid);
		re.setUsername(rname);
		re.setPassword(rpassword);
		
		Dbconnect data = new Dbconnect();
		int status=data.register(re);
		if(status>0) {
				System.out.println("Success"+status);
				req.getRequestDispatcher("AdminHome.html").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"test\").innerHTML = \"Registered Successfully.....  \"");  
				out.println("</script>");
			}else {
				System.out.println("error");
				req.getRequestDispatcher("AdminHome.html").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"test1\").innerHTML = \"Already Id is Registered.....  \"");  
				out.println("</script>");
			}
		}
	}