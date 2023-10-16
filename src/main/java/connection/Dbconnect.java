package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class Dbconnect  {
	//login
 public static List<Variables> demo(int id){
	 List <Variables> li =new ArrayList<Variables>();
	 try {
		 Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 System.out.println(id);
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select id,username,password from login where id="+id);  
			while(rs.next()) {
				Variables var = new Variables();
				var.setId(rs.getInt(1));
				var.setUsername(rs.getString(2));
				var.setPassword(rs.getString(3));
				li.add(var);
			} 
			con.close();
	 }
	 catch(Exception e) {
		 System.out.println(e);
	 }
	 return li;
 }
 // Register
 
 public static int register(Variables reg) {
	 int status=0;
	 try {
		 System.out.println("inserted");
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 PreparedStatement pt= con.prepareStatement("insert into website.login values(?,?,?)");
			 pt.setInt(1, reg.getId());
			 pt.setString(2, reg.getUsername());
			 pt.setString(3, reg.getPassword());
			 status=pt.executeUpdate();
			 con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
		return status;
	}
 
 
 // insert
 
 public static int insert(ContactVariables cvar) {
	 int status=0;
	 try {
		 System.out.println("called");
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 PreparedStatement pt= con.prepareStatement("insert into website.contact values(?,?,?,?)");
			 pt.setString(1, cvar.getName());
			 pt.setString(2, cvar.getEmail());
			 pt.setString(3, cvar.getPhoneno());
			 pt.setString(4, cvar.getMessage());
			 status=pt.executeUpdate();
			 con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
		return status;
	}
 
 
 // Employee Insert
 public static int addemp(EmployeeVariables add) {
	 int status=0;
	 try {
		 System.out.println("called");
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 PreparedStatement pt= con.prepareStatement("insert into website.employee values(?,?,?,?,?)");
			 pt.setInt(1, add.getId());
			 pt.setString(2, add.getName());
			 pt.setString(3, add.getPhoneno());
			 pt.setString(4, add.getDeptname());
			 pt.setString(5, add.getSal());
			 status=pt.executeUpdate();
			 con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
		return status;
	}
 
 
 // Select Contact
 
 
 public static List<ContactVariables> able(){
	 List <ContactVariables> lt = new ArrayList <ContactVariables>();
	 try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from contact");  
			while(rs.next()) {
				ContactVariables tact = new ContactVariables();
				tact.setName(rs.getString(1));
				tact.setEmail(rs.getString(2));
				tact.setPhoneno(rs.getString(3));
				tact.setMessage(rs.getString(4));
				lt.add(tact);
				}  
			
	 con.close();  
	}catch(Exception e){ 
		System.out.println(e);
	}
return lt;
}
 
 
 // Select Employee
 public static List<EmployeeVariables> semp(){
	 List <EmployeeVariables> esel = new ArrayList <EmployeeVariables>();
	 try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee");  
			while(rs.next()) {
				EmployeeVariables ems = new EmployeeVariables();
				ems.setId(rs.getInt(1));
				ems.setName(rs.getString(2));
				ems.setPhoneno(rs.getString(3));
				ems.setDeptname(rs.getString(4));
				ems.setSal(rs.getString(5));
				esel.add(ems);
				}  
			
	 con.close();  
	}catch(Exception e){ 
		System.out.println(e);
	}
return esel;
}
 
 //Admin Delete
 
 public static int delete(int i) {
		System.out.println("delete called"+i);
		int status=0;

		try{  
			System.out.println("Delete called");
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 PreparedStatement pt= con.prepareStatement("delete from website.employee where id=?");
			 pt.setInt(1, i);
			 status=pt.executeUpdate();
			 con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
			return status;
	}
 
 // update
 
 public static int update(EmployeeVariables empvar) {
		int status=0;
		try{  
			System.out.println("update called"+empvar.getId());
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/website","root","root");  
			 PreparedStatement pt= con.prepareStatement("update website.employee set name=?,phoneno=?,department=?,salary=? where id=?");
			 pt.setString(1, empvar.getName());
			 pt.setString(2, empvar.getPhoneno());
			 pt.setString(3, empvar.getDeptname());
			 pt.setString(4, empvar.getSal());
			 pt.setInt(5, empvar.getId());
			 status= pt.executeUpdate();
			 con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
			return status;
	}
 
}
