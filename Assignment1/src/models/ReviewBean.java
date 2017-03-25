package models;

import java.util.ArrayList;

public class ReviewBean {
	

	private int Id;
	private int ProductId;
	private int CustomerId;
	private String ReviewDate;
	private Byte Rating;
	private String Review;

	public ReviewBean() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getReviewDate() {
		return ReviewDate;
	}

	public void setReviewDate(String reviewDate) {
		ReviewDate = reviewDate;
	}

	public Byte getRating() {
		return Rating;
	}

	public void setRating(Byte rating) {
		Rating = rating;
	}

	public String getReview() {
		return Review;
	}

	public void setReview(String review) {
		Review = review;
	}
	
    public static ArrayList<ReviewBean> findReviewsbyProductID(int prodId) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	ArrayList<ReviewBean> list = db.DBgetReviewsbyProductId(prodId);
	   	db.closeConnection();
	   	return list;
    }
    
	public Users findUserbyUserId(int id) {   
		return Users.findUserbyId(id);
    }
	
	public static void addReview(ReviewBean review) {
		DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	db.DBaddReview(review);
	   	db.closeConnection();
	}
	
}
