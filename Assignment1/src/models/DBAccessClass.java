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
			        + "60, 5, 3, 100, 'Yeezy', 'this is a video String', "
			        + "'thumbnails/YeezyThumbnail');";
		  stmt.executeUpdate(sql);
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public void insertReviews() {
		
		
		try {
			stmt = conn.createStatement();
		
		  /** Following sql statements create an Employee table
		   * Insert values into the table
		   * Read all the rows and attributes from the table
		   */
		  String sql;
		  
		  sql = "Truncate table CustomerReviews;";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO CustomerReviews "
				+ "VALUES (111, 111, 101, '01/05/2017', '4', "
		        + "'Man this was a g8 product. I am also not a homosexual');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO CustomerReviews "
				+ "VALUES (112, 111, 102, '01/10/2017', '1', "
		        + "'This was not a good product. I feel bad that I purchased this.');";
		  stmt.executeUpdate(sql);
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
	}
	
	public void insertQuestions() {
		
		
		try {
			stmt = conn.createStatement();
		
		  /** Following sql statements create an Employee table
		   * Insert values into the table
		   * Read all the rows and attributes from the table
		   */
		  String sql;
		  
		  sql = "Truncate table ProductQA;";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO ProductQA "
				+ "VALUES (111, 111, 101, 'Will this end by suffering?', "
				+ "'Probs not');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO ProductQA "
				+ "VALUES (112, 111, 102, 'Can I make drugs out of this?', "
				+ "'');";
		  stmt.executeUpdate(sql);
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	

	public void DBaddQuestion(QuestionsBean questionBean) {
		try{
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO ProductQA (Id, ProductId, CustomerId, Question, Answer) VALUES (" + questionBean.getId() + ", " 
				+ questionBean.getProductId() + ", " + questionBean.getCustomerId() + ", '" 
				+ questionBean.getQuestion() + "', null)";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void DBaddReview(ReviewBean reviewBean) {
		try{
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO CustomerReviews (Id, ProductId, CustomerId, ReviewDate, Rating, Review) VALUES (" + reviewBean.getId() + ", " 
				+ reviewBean.getProductId() + ", " + reviewBean.getCustomerId() + ", '" 
				+ reviewBean.getReviewDate() + "', " + reviewBean.getRating() + ", '"
				+ reviewBean.getReview() + "')";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReviewBean> DBgetReviewsbyProductId(int id){
		
		ArrayList<ReviewBean> dbBeanList = new ArrayList<ReviewBean>();
		String sql = "SELECT * FROM CustomerReviews where ProductId=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ReviewBean dbBean = new ReviewBean();
				dbBean.setId(rs.getInt("Id"));
				dbBean.setProductId(rs.getInt("ProductId"));
				dbBean.setCustomerId(rs.getInt("CustomerId"));
				dbBean.setRating(rs.getByte("Rating"));
				dbBean.setReviewDate(rs.getString("ReviewDate"));
				dbBean.setReview(rs.getString("Review"));
				dbBeanList.add(dbBean);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBeanList;
		
	}
	
	public ArrayList<QuestionsBean> DBgetQuestionsbyProductId(int id){
		
		ArrayList<QuestionsBean> dbBeanList = new ArrayList<QuestionsBean>();
		String sql = "SELECT * FROM ProductQA where ProductId=?";
		try{
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				QuestionsBean dbBean = new QuestionsBean();
				dbBean.setId(rs.getInt("Id"));
				dbBean.setProductId(rs.getInt("ProductId"));
				dbBean.setCustomerId(rs.getInt("CustomerId"));
				dbBean.setQuestion(rs.getString("Question"));
				dbBean.setAnswer(rs.getString("Answer"));
				dbBeanList.add(dbBean);
			}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		return dbBeanList;
		
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
					+ "VALUES (102, 'Tianyi', 'Wang', '720 N 81st', "
			        + "'Lincoln', 'Nebraska', '68505', 'tianyiwang@gmail.com', "
			        + "'402-419-4133', '06/25/1995', "
			        + "0, 1, 5, 'twang', 'super');";
		  
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
					+ "VALUES (2, 'Jon Lee', '0123456789', 500.00, "
			        + "'Master Card', 100, 352, "
			        + "'0612');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO CreditCards "
				+ "VALUES (1, 'Firhard Roslan', '950611146279', 1000.00, "
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
				+ "VALUES (100, 100, 360, '01/15/2016', "
		        + "'720 N 81st', '720 N 81st', "
		        + "'4111111111111111');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Orders "
				+ "VALUES (101, 101, 180, '01/23/2016', "
		        + "'720 N 81st', '720 N 81st', "
		        + "'4111111111111111');";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO Orders "
					+ "VALUES (102, 102, 0, '01/30/2016', "
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
		String sql = "SELECT * FROM Orders where Id=?";
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
		String sql = "SELECT * FROM Orders where CustomerId=?";
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
	
	public void DBdecrementOrderTotal(int input_id, int take_back){
		int current_quantity = 0;
		int new_quantity = 0;
		String sql2 = "SELECT * FROM Orders WHERE Id = " + input_id;
		try{
			ps = conn.prepareStatement(sql2);
			ResultSet rs2 = ps.executeQuery();
			while(rs2.next()){
				current_quantity = rs2.getInt("TotalCost");
			}
			new_quantity = current_quantity - take_back;
			String sql = "UPDATE Orders SET TotalCost = " + new_quantity + " WHERE Id = " + input_id;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<OrderItems> DBgetOrderItemsbyOrderID(int orderId){

		ArrayList<OrderItems> dbBeanList = new ArrayList<OrderItems>();
		String sql = "SELECT * FROM OrderItems where OrderId=?";
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
				dbBean.setProductPrice(rs.getInt("ProductPrice"));
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
	
	public void DBChangeOrderItemStatusCancelled(int input_id){
		String sql = "UPDATE OrderItems SET Status = " + 0 + " where Id= " + input_id;
		try{
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void DBaddQuantity(int input_id, int add_back){
		int current_quantity = 0;
		int new_quantity = 0;
		String sql2 = "SELECT * FROM Products WHERE Id = " + input_id;
		try{
			ps = conn.prepareStatement(sql2);
			ResultSet rs2 = ps.executeQuery();
			while(rs2.next()){
				current_quantity = rs2.getInt("AvailableQuantity");
			}
			new_quantity = current_quantity + add_back;
			String sql = "UPDATE Products SET AvailableQuantity = " + new_quantity + " WHERE Id = " + input_id;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public double DBaddCredit(double productPrice, int input_id, int user_id) {
		double dbBean = 0;
		double summation = 0;
		String sql2 = "SELECT * FROM CreditCards WHERE UserId = " + user_id;
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
		String sql2 = "SELECT * FROM CreditCards WHERE CreditCardNumber = " + cNumber;
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

	public Users DBgetUserinfo(String username, String password) {
		Users dbBean = new Users();
		String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
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

	public OrdersBean DBaddOrder(OrdersBean ordBean) {
		
		OrdersBean dbBean = new OrdersBean();
		try{
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO Orders (Id, CustomerId, TotalCost, OrderDate, ShippingAddress, BillingAddress, CreditCardNumber) VALUES (" + ordBean.getId() + ", " 
				+ ordBean.getCustomerId() + ", " + ordBean.getTotalCost() + ", '" 
				+ ordBean.getOrderDate() + "', '" + ordBean.getShippingAddress() + "', '" 
				+ ordBean.getBillingAddress() + "', '" + ordBean.getCrediCardNumber() + "')";
			stmt.executeUpdate(sql);
			
//			sql = "SELECT * FROM Orders WHERE CustomerId = ? AND TotalCost = ? "
//					+ "AND OrderDate = ? AND ShippingAddress = ? AND BillingAddress = ? "
//					+ "AND CreditCardNumber = ?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, ordBean.getCustomerId());
//			ps.setInt(2, ordBean.getTotalCost());
//			ps.setString(3, ordBean.getOrderDate());
//			ps.setString(4, ordBean.getShippingAddress());
//			ps.setString(5, ordBean.getShippingAddress());
//			ps.setString(6, ordBean.getCrediCardNumber());
//			
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				dbBean.setId(rs.getInt("Id"));
//				dbBean.setCustomerId(rs.getInt("CustomerId"));
//				dbBean.setTotalCost(rs.getInt("TotalCost"));
//				dbBean.setOrderDate(rs.getString("OrderDate"));
//				dbBean.setShippingAddress(rs.getString("ShippingAddress"));
//				dbBean.setBillingAddress(rs.getString("BillingAddress"));
//				dbBean.setCrediCardNumber(rs.getString("CreditCardNumber"));
//			}

		} catch (SQLException e){
			e.printStackTrace();
		}
		return dbBean;
	}

	public void DBaddOrderItem(OrderItems ordItem) {
		try{
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO OrderItems (Id, OrderId, SellerId, ProductId, ProductPrice, Quantity, ShippingStatus, ShippingRefNo, Status) VALUES (" + ordItem.getId() + ", " 
				+ ordItem.getOrderId() + ", " + ordItem.getSellerId() + ", " 
				+ ordItem.getProductId() + ", " + ordItem.getProductPrice() + ", " 
				+ ordItem.getQuantity() + ", " + ordItem.getShippingStatus() + ", "
				+ ordItem.getShippingRefNo() + ", " + ordItem.getStatus() + ")";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void insertOrderItems() {
		  
		  try {
			stmt = conn.createStatement();
		
		 
		  /** Following sql statements create an Employee table
		   * Insert values into the table
		   * Read all the rows and attributes from the table
		   */
		  String sql;
		  
		  sql = "Truncate table OrderItems;";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO OrderItems VALUES (1, 100, 100, 111, 60, 3, 1, 1, 1)";
		  stmt.executeUpdate(sql);
		  
		  sql = "INSERT INTO OrderItems VALUES (2, 101, 101, 112, 60, 3, 1, 2, 1)";
		  stmt.executeUpdate(sql);

		  sql = "INSERT INTO OrderItems VALUES (3, 102, 102, 113, 60, 3, 1, 3, 0)";
		  stmt.executeUpdate(sql);

		  sql = "INSERT INTO OrderItems VALUES (4, 100, 100, 112, 55, 3, 1, 4, 0)";
		  stmt.executeUpdate(sql);
		 
		  sql = "INSERT INTO OrderItems VALUES (5, 100, 100, 113, 60, 3, 0, 3, 1)";
		  stmt.executeUpdate(sql);
		 
		  sql = "INSERT INTO OrderItems VALUES (6, 101, 101, 113, 60, 3, 1, 3, 0)";
		  stmt.executeUpdate(sql);
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}

	public int DBdeleteRequestedQuantity(int requestedQuantity, int input_id){
		int dbBean = 0;
		int newAvailableQuantity = 0;
		String sql2 = "SELECT AvailableQuantity FROM Products WHERE Id = ?";
		try{
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, input_id);
			ResultSet rs2 = ps.executeQuery();
			while(rs2.next()){
				dbBean = rs2.getInt("AvailableQuantity");
			}
			newAvailableQuantity = dbBean - requestedQuantity;
			System.out.println("UPDATE Products SET AvailableQuantity = " + newAvailableQuantity + " WHERE Id = " + input_id);
			String sql ="UPDATE Products SET AvailableQuantity = " + newAvailableQuantity + " WHERE Id = " + input_id;
			ps.executeUpdate(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return newAvailableQuantity;
	}
	//END
}
	