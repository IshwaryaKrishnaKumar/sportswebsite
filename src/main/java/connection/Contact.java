package connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Contact")

public class Contact extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		String cname = req.getParameter("name");
		String cemail= req.getParameter("email");
		String cphoneno = req.getParameter("phoneno");
		String cmessage = req.getParameter("message");
		ContactVariables var =new ContactVariables();
		var.setName(cname);
		var.setEmail(cemail);
		var.setPhoneno(cphoneno);
		var.setMessage(cmessage);
		Dbconnect data = new Dbconnect();
		int status=data.insert(var);
		if(status>0) {
				System.out.println("Success"+status);
				req.getRequestDispatcher("Contact.html").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"test\").innerHTML = \"Thanks For Your Response.....  \"");  
				out.println("</script>");
			}else {
				System.out.println("error");
			}
		}
	}