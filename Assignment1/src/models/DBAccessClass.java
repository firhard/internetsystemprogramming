package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccessClass {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/jlee";
	
	//  Database credentials
	static final String USER = "jlee"; // Replace with your CSE_LOGIN
	static final String PASS = "e@Y9RJ";   // Replace with your CSE MySQL_PASSWORD

	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Example Methods below (not used), these methods figuratively get called by bean methods
//	public String getSalary(String lastName) {
//		 String salary = "-99.0";
//		 String sql = "SELECT * FROM Employees where Last_Name=?";
//		 try {
//			 ps = conn.prepareStatement(sql);
//		
//			 ps.setString(1, lastName);
//			  
//			 ResultSet rs = ps.executeQuery();
//			  
//			  //Extract data from result set
//			  while(rs.next()){
//				    //Retrieve by column name
//				    salary = rs.getString("Salary");
//			  }
//		  
//		 } catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//	     }
//		 return salary;
//	}
//	
//	public void addSingleEmployee(EmployeeBean employee) {
//		  
//		try {
//		  stmt = conn.createStatement();
//		  String sql;
//		  //String first, String name, String last_name, String salary
//		  int id = employee.getId();
//		  String firstName = employee.getFirst_name();
//		  String lastName = employee.getLast_name();
//		  String salary = employee.getSalary();
//		  
//
//		  sql = "INSERT INTO Employees (ID, First_Name, Last_Name, Salary) " +
//		          "VALUES ('" + id +
//		          "', '" + firstName + 
//				  "', '" + lastName + 
//				  "', '" + salary + "')";
//		  stmt.executeUpdate(sql);
//		  
//		  
//		  
//		  } catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		}
//		
//	}
}
