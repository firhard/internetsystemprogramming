package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class DBAccessClass {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/jlee";
	
	//  Database credentials
	static final String USER = "jlee"; // Replace with your CSE_LOGIN
	static final String PASS = "firhard";   // Replace with your CSE MySQL_PASSWORD

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
	public void insertProducts() {
		  
		  try {
			stmt = conn.createStatement();
		
		 
		  /** Following sql statements create an Employee table
		   * Insert values into the table
		   * Read all the rows and attributes from the table
		   */
		  String sql;
		  
		  sql = "Truncate table Products;";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Products "
				+ "VALUES (111, 'Adidas Jacket', '1', 'A really nice jacket', "
		        + "55, 4, 5, 100, 'this is a photo String', 'this is a video String', "
		        + "'thumbnails/AdidasThumbnail');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Products "
				+ "VALUES (112, 'Nike Jacket', '2', 'A reall cool jacket', "
		        + "60, 5, 5, 101, 'this is a photo String', 'this is a video String', "
		        + "'thumbnails/NikeThumbnail');";
		  stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public ProductsBean DBgetProductbyId(int id){
		
		ProductsBean dbBean = new ProductsBean();
		String sql = "SELECT * FROM Products where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
				dbBean.setProductName(rs.getString("ProductName"));
				dbBean.setProductCategoryIndex(rs.getInt("ProductCategoryIndex"));
				dbBean.setProductDescription(rs.getString("ProductDescription"));
				dbBean.setPrice(rs.getInt("Price"));
				dbBean.setAvailableQuantity(rs.getInt("AvailableQuantity"));
				dbBean.setSellerId(rs.getInt("SellerId"));
				dbBean.setProductPhotosLinks(rs.getString("ProductPhotosLinks"));
				dbBean.setProductVideosLinks(rs.getString("ProductVideosLinks"));
				dbBean.setProductThumbnail(rs.getString("ProductThumbnail"));
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean;
		
	}
	public ArrayList<ProductsBean> DBgetProductsbyName(String name){
		
		ArrayList<ProductsBean> dbBeanList = new ArrayList<ProductsBean>();
		String sql = "SELECT * FROM Products where ProductName=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){

                ProductsBean dbBean = new ProductsBean();
				dbBean.setId(rs.getInt("Id"));
				dbBean.setProductName(rs.getString("ProductName"));
				dbBean.setProductCategoryIndex(rs.getInt("ProductCategoryIndex"));
				dbBean.setProductDescription(rs.getString("ProductDescription"));
				dbBean.setPrice(rs.getInt("Price"));
				dbBean.setAvailableQuantity(rs.getInt("AvailableQuantity"));
				dbBean.setSellerId(rs.getInt("SellerId"));
				dbBean.setProductPhotosLinks(rs.getString("ProductPhotosLinks"));
				dbBean.setProductVideosLinks(rs.getString("ProductVideosLinks"));
				dbBean.setProductThumbnail(rs.getString("ProductThumbnail"));
				dbBeanList.add(dbBean);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBeanList;
		
	}
	
	public ArrayList<ProductsBean> DBgetProductsbyNameandCategory(String name, int category){
		
		ArrayList<ProductsBean> dbBeanList = new ArrayList<ProductsBean>();
		String sql = "SELECT * FROM Products where ProductName=? AND ProductCategoryIndex=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, category);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){

                ProductsBean dbBean = new ProductsBean();
				dbBean.setId(rs.getInt("Id"));
				dbBean.setProductName(rs.getString("ProductName"));
				dbBean.setProductCategoryIndex(rs.getInt("ProductCategoryIndex"));
				dbBean.setProductDescription(rs.getString("ProductDescription"));
				dbBean.setPrice(rs.getInt("Price"));
				dbBean.setAvailableQuantity(rs.getInt("AvailableQuantity"));
				dbBean.setSellerId(rs.getInt("SellerId"));
				dbBean.setProductPhotosLinks(rs.getString("ProductPhotosLinks"));
				dbBean.setProductVideosLinks(rs.getString("ProductVideosLinks"));
				dbBean.setProductThumbnail(rs.getString("ProductThumbnail"));
				dbBeanList.add(dbBean);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBeanList;
		
	}
	
	public Users DBgetUserbyUsernameandPassword(String username, String password){
			
        Users dbBean = new Users();
		String sql = "SELECT * FROM Users where Username=? AND Password=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){

				dbBean.setId(rs.getInt("Id"));
				dbBean.setFirstName(rs.getString("FirstName"));
				dbBean.setLastName(rs.getString("LastName"));
				dbBean.setAddress(rs.getString("Address"));
				dbBean.setCity(rs.getString("City"));
				dbBean.setState(rs.getString("State"));
				dbBean.setPostalCode(rs.getString("PostalCode"));
				dbBean.setEmailAddress(rs.getString("EmailAddress"));
				dbBean.setPhoneNumber(rs.getString("PhoneNumber"));
				dbBean.setBirthday(rs.getString("Birthday"));
				dbBean.setType(rs.getByte("Type"));
				dbBean.setStatus(rs.getByte("Status"));
				dbBean.setNumOfVisits(rs.getInt("NumOfVisits"));
				dbBean.setUserName(rs.getString("Username"));
				dbBean.setPassword(rs.getString("Password"));
				
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean;
		
	}
	
	public boolean DBUsernameTaken(String username){
		
        Users dbBean = new Users();
		String sql = "SELECT * FROM Users where Username=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){

				dbBean.setId(rs.getInt("Id"));
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean.getId() != 0;
		
	}
	
	public void DBsetUser(String username, String password){
		
		
		try {	
		  stmt = conn.createStatement();
		  String sql;

		  	sql = "INSERT INTO Users (Username, Password) " +
			          "VALUES ('" + username +
					  "', '" + password + "')";
			stmt.executeUpdate(sql);
		  	
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public void insertUsers() {
		  
		try {
		  stmt = conn.createStatement();
		  String sql;
		  
		  sql = "Truncate table Users;";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Users "
					+ "VALUES (100, 'Jon', 'Lee', '720 N 81st', "
			        + "'Lincoln', 'Nebraska', '68505', 'jonathan_lee7@live.com', "
			        + "'402-419-4133', '06/25/1995', "
			        + "0, 1, 5, 'jlee', 'super');";
		  
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Users "
					+ "VALUES (101, 'Firhard', 'Roslan', '720 N 81st', "
			        + "'Lincoln', 'Nebraska', '68505', 'firhard@gmail.com', "
			        + "'402-419-4133', '06/25/1995', "
			        + "0, 1, 5, 'mfirhard', 'super');";
		  
		  stmt.executeUpdate(sql);
		  
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public Users DBgetUserbyId(int id){
		
        Users dbBean = new Users();
		String sql = "SELECT * FROM Users where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				dbBean.setId(rs.getInt("Id"));
				dbBean.setFirstName(rs.getString("FirstName"));
				dbBean.setLastName(rs.getString("LastName"));
				dbBean.setAddress(rs.getString("Address"));
				dbBean.setCity(rs.getString("City"));
				dbBean.setState(rs.getString("State"));
				dbBean.setPostalCode(rs.getString("PostalCode"));
				dbBean.setEmailAddress(rs.getString("EmailAddress"));
				dbBean.setPhoneNumber(rs.getString("PhoneNumber"));
				dbBean.setBirthday(rs.getString("Birthday"));
				dbBean.setType(rs.getByte("Type"));
				dbBean.setStatus(rs.getByte("Status"));
				dbBean.setNumOfVisits(rs.getInt("NumOfVisits"));
				dbBean.setUserName(rs.getString("Username"));
				dbBean.setPassword(rs.getString("Password"));
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean;
		
	}
		
	
	

	public boolean DBverifyCreditCard(String cHolderName, String cType, String cNumber, String sCode, Date eDate){
		TransactionsBean dbBean = new TransactionsBean();
		String sql = "SELECT * FROM CreditCards where CardHolderName=? AND CreditCardNumber=? AND ExpirationDate=? AND CardType=? AND CVV=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cHolderName);
			ps.setString(2, cNumber);
			ps.setDate(3, (java.sql.Date) eDate);
			ps.setString(4, cType);
			ps.setString(5, sCode);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
				dbBean.setCardHolderName(rs.getString("CardHolderName"));
				dbBean.setCreditCardNumber(rs.getString("CreditCardNumber"));
				dbBean.setExpirationDate(rs.getDate("ExpirationDate"));
				dbBean.setCardType(rs.getString("CardType"));
				dbBean.setCVV(rs.getString("CVV"));
				dbBean.setUserId(rs.getInt("UserId"));
				dbBean.setBalance(rs.getDouble("Balance"));
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean.getId() != 0;
	}
	
	public int DBverifyBalance(String cHolderName){
		
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
