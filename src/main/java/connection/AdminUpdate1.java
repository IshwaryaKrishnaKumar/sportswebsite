package connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class AdminUpdate1 extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter out= res.getWriter();
	res.setContentType("text/html");
	int id=Integer.parseInt(req.getParameter("id"));
	String name =req.getParameter("name");
	String phoneno = req.getParameter("phoneno");
	String department = req.getParameter("depname");
	String salary = req.getParameter("sal");
	out.print("<div style='margin:100px;'>");
	out.println("<form action='update2'><table><tr>");
	out.print("<td>ID</td><td><input type='hidden' name='hid' value='"+id+"' ></td><td>"+id+"</td></tr>");
	out.print("<tr><td>Employee Name</td><td><input type='text' name='name' value='"+name+"' required></td></tr>");
	out.print("<tr><td>Phone Number</td><td><input type='text' name='phoneno' value='"+phoneno+"' required></td></tr>");
	out.print("<tr><td>Department</td><td><input type='text' name='depname' value='"+department+"' required></td></tr>");
	out.print("<tr><td>Salary</td><td><input type='text' name='sal' value='"+salary+"' required></td></tr>");
	out.print("<tr><td><input type='submit' value='Update' style='text-decoration:none; border:2px solid #003166;color:#003166;padding:5px;'></td></tr>");
	out.print("<br>");
	out.print("<br>");
	out.print("</table>	</form>");
	out.print("</div>");
	}
}
