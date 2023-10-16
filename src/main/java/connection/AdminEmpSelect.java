package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminEmployee")
public class AdminEmpSelect extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeVariables emp = new EmployeeVariables();
		List<EmployeeVariables> elst = new ArrayList<EmployeeVariables>();
		Dbconnect db = new Dbconnect();
		elst = db.semp();
		for (EmployeeVariables de1 : elst) {
			System.out.println(de1.getName());
		}
		out.print("<div style='margin:30px;padding:10px;'>");
		out.print(
				"<a href='AdminAddEmployee.html' style='text-decoration:none; border:2px solid #003166;color:#003166;padding:5px;'>Add Employee");
		out.print("</a>");
		out.print("<br>");
		out.print("<br>");
		out.print("<table style='width:100%; border:2px solid black;border-collapse:collapse; text-align:center'>");
		out.print(
				"<tr style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'><th style='border-collapse:collapse;padding:10px; border:2px solid black;color:red; text-align:center'>Employee Id</th><th style='border-collapse:collapse;padding:10px; border:2px solid black;color:red; text-align:center'>Name</th><th style='border-collapse:collapse;padding:10px;color:red; border:2px solid black; text-align:center' >Phone Number</th><th style='border-collapse:collapse;padding:10px;color:red; border:2px solid black; text-align:center'>Department</th><th style='border-collapse:collapse;color:red;padding:10px; border:2px solid black; text-align:center'>Salary</th><th style='border-collapse:collapse;padding:10px; border:2px solid black;color:red; text-align:center'>Action</th></tr>");
		for (EmployeeVariables de1 : elst) {
			out.print(
					"<tr style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'><td style='border-collapse:collapse; padding:10px;border:2px solid black; text-align:center'>"
							+ de1.getId()
							+ "</td><td style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'>"
							+ de1.getName()
							+ "</td><td style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'>"
							+ de1.getPhoneno()
							+ "</td><td style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'>"
							+ de1.getDeptname()
							+ "</td><td style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'>"
							+ de1.getSal()
							+ "</td><td style='border-collapse:collapse;padding:10px; border:2px solid black; text-align:center'><a href='update?id="
							+ de1.getId() + "&name=" + de1.getName() + "&phoneno=" + de1.getPhoneno() + "&depname="
							+ de1.getDeptname() + "&sal=" + de1.getSal()
							+ "' style='text-decoration:none; border:2px solid #003166 ;padding:4px;'>Update</a>&nbsp;&nbsp;<a href='delete?id="
							+ de1.getId()
							+ "'style='text-decoration:none; border:2px solid #003166 ;padding:4px;'>Delete</a></td></tr>");

		}

		out.print("</table>");
		out.print("<br>");
		out.print("<h3 id='test' style='color:green;'></h3>");
		out.print("<br>");
		out.print(
				"<a href='AdminHome.html' style='text-decoration:none; border:2px solid #003166;position:absolute;right:40px;color:#003166;padding:5px;'>Previous Page");
		out.print("</a>");
		out.print("</div>");
	}
}
