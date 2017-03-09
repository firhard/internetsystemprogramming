package models;

import java.util.Date;

public class TransactionsBean {

	private int Id;
	private String CardHolderName;
	private String CreditCardNumber;
	private double Balance;
	private String CardType;
	private int UserId;
	private String CVV;
	private Date ExpirationDate; 
	
	public TransactionsBean(){
		super();
	}
	
	public TransactionsBean(int Id, String CardHolderName, String CreditCardNumber, double Balance, String CardType, int UserId, String CVV, Date ExpirationDate){
		
	}
	
	public int getId(){
		return Id;
	}
	
	public void setId(int id){
		Id = id;
	}
	 
	
	public String getCardHolderName(){
		return CardHolderName;
	}
	
	public void setCardHolderName(String cardHolderName){
		this.CardHolderName = cardHolderName;
	}
	
	public String getCreditCardNumber(){
		return CreditCardNumber;
	}
	
	public void setCreditCardNumber(String creditCardNumber){
		this.CreditCardNumber = creditCardNumber;
	}
	
	public double getBalance(){
		return Balance;
	}
	
	public void setBalance(double balance){
		this.Balance = balance;
	}
	
	public String getCardType(){
		return CardType;
	}
	
	public void setCardType(String cardType){
		this.CardType = cardType;
	}
	
	public int getUserId(){
		return UserId;
	}
	
	public void setUserId(int userid){
		this.UserId = userid;
	}
	
	public String getCVV(){
		return CVV;
	}
	
	public void setCVV(String cvv){
		this.CVV = cvv;
	}
	
	public Date getExpirationDate(){
		return ExpirationDate;
	}
	
	public void setExpirationDate(Date expirationDate){
		this.ExpirationDate = expirationDate;
	}

	public static boolean verifyCreditCard(String cHolderName, String cType, String cNumber, String sCode, String eDate){
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	boolean verified = db.DBverifyCreditCard(cHolderName, cType, cNumber, sCode, eDate);
	   	return verified;
	}
	
	public static double availableBalance(String cHolderName){
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	double balance = db.DBverifyBalance(cHolderName);
	   	return balance;
	}

	public static double addCreditafterCancellation(double productPrice, int input_id) {
		DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	double balance = db.DBaddCredit(productPrice, input_id);
	   	return balance;
	}

	public static double deductCredit(double Price, String cNumber, String sCode) {
		DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	double balance = db.DBdeductCredit(Price, cNumber, sCode);
	   	return balance;
	}
	
	
}
