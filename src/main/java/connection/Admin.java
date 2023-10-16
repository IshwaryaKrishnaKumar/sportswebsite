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

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ContactVariables cont = new ContactVariables();
		List <ContactVariables> lst = new ArrayList <ContactVariables>();
		Dbconnect db =new Dbconnect();
		lst=db.able();
		for(ContactVariables de1:lst) {
			System.out.println(de1.getName());
		}
		out.print("<div style='margin:30px;padding:10px;'>");
		out.print("<table style='width:100%; border:2px solid black;border-collapse:collapse; text-align:center'>");
		out.print("<tr style='border-collapse:collapse; border:2px solid black; text-align:center'><th style='border-collapse:collapse; border:2px solid black;color:red; text-align:center'>Name</th><th style='border-collapse:collapse;color:red; border:2px solid black; text-align:center' >Email</th><th style='border-collapse:collapse;color:red; border:2px solid black; text-align:center'>PhoneNo</th><th style='border-collapse:collapse;color:red; border:2px solid black; text-align:center'>Message</th></tr>");
	for(ContactVariables de1:lst) {
		out.print("<tr style='border-collapse:collapse; border:2px solid black; text-align:center'><td style='border-collapse:collapse; border:2px solid black; text-align:center'>"+de1.getName()+"</td><td style='border-collapse:collapse; border:2px solid black; text-align:center'>"+de1.getEmail()+"</td><td style='border-collapse:collapse; border:2px solid black; text-align:center'>"+de1.getPhoneno()+"</td><td style='border-collapse:collapse; border:2px solid black; text-align:center'>"+de1.getMessage()+"</td></tr>");
		
	}
	
	out.print("</table>");
	out.print("<br>");
	out.print("<br>");
	out.print("<a href='AdminHome.html' style='text-decoration:none; border:2px solid #003166;position:absolute;right:40px;color:#003166;padding:5px;'>Previous Page");
	out.print("</a>");
	out.print("</div>");
	}
}
