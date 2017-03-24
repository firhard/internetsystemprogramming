package models;

import java.util.ArrayList;

public class QuestionsBean {
	
	private int Id;
	private int ProductId;
	private int CustomerId;
	private String Question;
	private String Answer;
	
	public QuestionsBean() {
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
	
	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}
	
    public static ArrayList<QuestionsBean> findQuesetionsbyProductId(int prodId) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	ArrayList<QuestionsBean> list = db.DBgetQuestionsbyProductId(prodId);
	   	db.closeConnection();
	   	return list;
    }
    
	public Users findUserbyUserId(int id) {   
		return Users.findUserbyId(id);
    }

}
