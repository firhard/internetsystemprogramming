package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAccessClass {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	
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
		        + "55, 4, 5, 100, 'Adidas', 'this is a video String', "
		        + "'thumbnails/AdidasThumbnail');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Products "
				+ "VALUES (112, 'Nike Jacket', '2', 'A reall cool jacket', "
		        + "60, 5, 3, 101, 'Nike', 'this is a video String', "
		        + "'thumbnails/NikeThumbnail');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Products "
					+ "VALUES (113, 'Yeezy', '3', 'A really cool shoe', "
			        + "60, 5, 3, 102, 'Adidas', 'this is a video String', "
			        + "'thumbnails/YeezyThumbnail');";
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
				dbBean.setEstimatedDeliveryDays(rs.getInt("EstimatedDeliveryDays"));
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
		  
		  sql = "INSERT INTO Users "
					+ "VALUES (102, 'Tianyi, 'Wang', '720 N 81st', "
			        + "'Lincoln', 'Nebraska', '68505', 'tianyiwang@gmail.com', "
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
	
public Users DBgetUserbyUserName(String username){
		
        Users dbBean = new Users();
		String sql = "SELECT * FROM Users where Username=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
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
		
	
	public void insertCreditCard(){
		  
		  try {
			stmt = conn.createStatement();

		  String sql;
		  
		  sql = "Truncate table CreditCards;";
		  stmt.executeUpdate(sql);

		  sql = "INSERT INTO CreditCards "
					+ "VALUES (2, 'Jon Lee', '0123456789', 20000.00, "
			        + "'Master Card', 100, 352, "
			        + "'0612');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO CreditCards "
				+ "VALUES (1, 'Firhard Roslan', '950611146279', 10000.00, "
		        + "'Visa', 101, 158, "
		        + "'0511');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO CreditCards "
					+ "VALUES (3, 'Tianyi Wang', '987654321123456789', 30000.00, "
			        + "'American Express', 102, 588, "
			        + "'0612');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO CreditCards "
					+ "VALUES (4, '1', '1', 3000000.00, "
			        + "'Visa', 102, 1, "
			        + "'1');";
		  stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	
	}

	public boolean DBverifyCreditCard(String cHolderName, String cType, String cNumber, String sCode, String eDate){
		TransactionsBean dbBean = new TransactionsBean();
		String sql = "SELECT * FROM CreditCards where CardHolderName=? AND CreditCardNumber=? AND ExpirationDate=? AND CardType=? AND CVV=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cHolderName);
			ps.setString(2, cNumber);
			ps.setString(3, eDate);
			ps.setString(4, cType);
			ps.setString(5, sCode);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean.getId() != 0;
	}
	
	public double DBverifyBalance(String cHolderName){
		double dbBean = 0;
		String sql = "SELECT * FROM CreditCards where CardHolderName=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, cHolderName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dbBean = rs.getDouble("Balance");
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return dbBean;
	}
	
	
	public void insertOrders() {
		  
		  try {
			stmt = conn.createStatement();

		  String sql;
		  
		  sql = "Truncate table Orders;";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Orders "
				+ "VALUES (100, 100, 55, '01/15/2016', "
		        + "'720 N 81st', '720 N 81st', "
		        + "'4111111111111111');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Products "
				+ "VALUES (101, 101, 60, '01/23/2016', "
		        + "'720 N 81st', '720 N 81st', "
		        + "'4111111111111111');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Products "
					+ "VALUES (102, 102, 60, '01/30/2016', "
			        + "'720 N 81st', '720 N 81st', "
			        + "'4111111111111111');";
			  stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}

	public OrdersBean DBgetOrderbyId(int id){
		OrdersBean dbBean = new OrdersBean();
		String sql = "SELECT * FROM Products where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
				dbBean.setCustomerId(rs.getInt("CustomerId"));
				dbBean.setTotalCost(rs.getInt("TotalCost"));
				dbBean.setOrderDate(rs.getString("OrderDate"));
				dbBean.setShippingAddress(rs.getString("ShippingAddress"));
				dbBean.setBillingAddress(rs.getString("BillingAddress"));
				dbBean.setCrediCardNumber(rs.getString("CreditCardNumber"));
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean;
		
	}
	
	public ArrayList<OrdersBean> DBgetOrderbyCustomerId(int CustomerId){

		ArrayList<OrdersBean> dbBeanList = new ArrayList<OrdersBean>();
		String sql = "SELECT * FROM Products where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, CustomerId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
                OrdersBean dbBean = new OrdersBean();
				dbBean.setId(rs.getInt("Id"));
				dbBean.setCustomerId(rs.getInt("CustomerId"));
				dbBean.setTotalCost(rs.getInt("TotalCost"));
				dbBean.setOrderDate(rs.getString("OrderDate"));
				dbBean.setShippingAddress(rs.getString("ShippingAddress"));
				dbBean.setBillingAddress(rs.getString("BillingAddress"));
				dbBean.setCrediCardNumber(rs.getString("CreditCardNumber"));
				dbBeanList.add(dbBean);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBeanList;
		
	}
	
	
	
	public ArrayList<OrderItems> DBgetOrderItemsbyOrderID(int orderId){

		ArrayList<OrderItems> dbBeanList = new ArrayList<OrderItems>();
		String sql = "SELECT * FROM Products where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, orderId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
                OrderItems dbBean = new OrderItems();
				dbBean.setId(rs.getInt("Id"));
				dbBean.setOrderId(rs.getInt("OrderId"));
				dbBean.setSellerId(rs.getInt("SellerId"));
				dbBean.setProductId(rs.getInt("ProductId"));
				dbBean.setQuantity(rs.getInt("Quantity"));
				dbBean.setShippingStatus(rs.getByte("ShippingStatus"));
				dbBean.setShippingRefNo(rs.getInt("ShippingRefNo"));
				dbBean.setStatus(rs.getByte("Status"));
				dbBeanList.add(dbBean);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBeanList;
		
	}
	
	public OrderItems DBgetOrderItembyOrderItemId(int id){
		
		OrderItems dbBean = new OrderItems();
		String sql = "SELECT * FROM OrderItems where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
				dbBean.setOrderId(rs.getInt("OrderId"));
				dbBean.setSellerId(rs.getInt("SellerId"));
				dbBean.setProductId(rs.getInt("ProductId"));
				dbBean.setProductPrice(rs.getInt("ProductPrice"));
				dbBean.setQuantity(rs.getInt("Quantity"));
				dbBean.setShippingStatus(rs.getByte("ShippingStatus"));
				dbBean.setShippingRefNo(rs.getInt("ShippingRefNo"));
				dbBean.setStatus(rs.getByte("Status"));
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean;
		
	}
	
	public boolean DBverifyShipment(int input_id){
		OrderItems dbBean = new OrderItems();
		String sql = "SELECT * FROM CreditCards where ShippingStatus=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, input_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBean.getId() != 0;
	}
	
	public OrderItems DBDeleteOrderItem(int input_id){
		OrderItems dbBean = new OrderItems();
		String sql = "DELETE FROM OrderItems where Id=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1,input_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dbBean.setId(rs.getInt("Id"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return dbBean;
	}

	public double DBaddCredit(double productPrice, int input_id) {
		double dbBean = 0;
		double summation = 0;
		String sql2 = "SELECT * FROM CreditCards";
		String sql ="UPDATE CreditCards SET Balance = ? WHERE Id = ?";
		try{
			ps = conn.prepareStatement(sql2);
			ResultSet rs2 = ps.executeQuery();
			while(rs2.next()){
				dbBean = rs2.getDouble("Balance");
			}
			summation = dbBean + productPrice;
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, summation);
			ps.setInt(2, input_id);
			sql ="UPDATE CreditCards SET Balance = " + summation + " WHERE Id = " + input_id;
			ps.executeUpdate(sql);
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return summation;
	}

	public double DBdeductCredit(double price, String cNumber, String sCode) {
		double dbBean = 0;
		double summation = 0;
		String sql2 = "SELECT * FROM CreditCards";
		String sql ="UPDATE CreditCards SET Balance = ? WHERE CreditCardNumber = ? AND CVV = ?";
		try{
			ps2 = conn.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				dbBean = rs2.getDouble("Balance");
			}
			summation = dbBean - price;
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, summation);
			ps.setString(2, cNumber);
			ps.setString(3, sCode);
			sql = "UPDATE CreditCards SET Balance = " + summation + " WHERE CreditCardNumber = " + cNumber + " AND CVV = " + sCode;
			ps.executeUpdate(sql);
			
			System.out.println("Inserted records into the table...");
		} catch (SQLException e){
			e.printStackTrace();
		}
		return summation;
	}
}
	
	