package connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmp")

public class AddEmployee extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		int eid=Integer.parseInt(req.getParameter("id"));
		String ename= req.getParameter("name");
		String ephoneno = req.getParameter("phoneno");
		String edepname= req.getParameter("depname");
        String esalary = req.getParameter("sal");		
		EmployeeVariables empl =new EmployeeVariables();
		empl.setId(eid);
		empl.setName(ename);
		empl.setPhoneno(ephoneno);
		empl.setDeptname(edepname);
		empl.setSal(esalary);
		Dbconnect data = new Dbconnect();
		int status=data.addemp(empl);
		if(status>0) {
				System.out.println("Success"+status);
				req.getRequestDispatcher("AdminAddEmployee.html").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"test\").innerHTML = \"Data Inserted Successfully.....  \"");  
				out.println("</script>");
			}else {
				System.out.println("error");
				req.getRequestDispatcher("AdminAddEmployee.html").include(req, res);
				out.println("<script type=\"text/javascript\">");  
				out.println("document.getElementById(\"test1\").innerHTML = \"Already Id is Registered.....  \"");  
				out.println("</script>");
			}
		}
}
