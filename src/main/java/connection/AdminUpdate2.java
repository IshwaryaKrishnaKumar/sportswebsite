package connection;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update2")
public class AdminUpdate2 extends HttpServlet {
		public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter out= res.getWriter();
			res.setContentType("text/html");
			System.out.println("called");
			System.out.println((req.getParameter("hid")));
			int id=Integer.parseInt(req.getParameter("hid"));
						String name= req.getParameter("name");
						String phoneno=req.getParameter("phoneno");
						String department=req.getParameter("depname");
						String salary = req.getParameter("sal");
			EmployeeVariables var= new EmployeeVariables();
			var.setId(id);
			var.setName(name);
			var.setPhoneno(phoneno);
			var.setDeptname(department);
			var.setSal(salary);
			int status=Dbconnect.update(var);
			if(status>0) {
				System.out.println("Updated successfully");
				req.getRequestDispatcher("AdminEmployee").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"test\").innerHTML = \"succesfully updated\"");  
				out.println("</script>");
			}else {
				System.out.println("error");
			}
			}
}

