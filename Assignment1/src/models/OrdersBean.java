package models;

import java.util.ArrayList;

public class OrdersBean {

	private int Id;
	private int CustomerId;
	private int TotalCost;
	private String OrderDate;
	private String ShippingAddress;
	private String BillingAddress;
	private String CrediCardNumber;

	public OrdersBean() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public int getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}

	public String getCrediCardNumber() {
		return CrediCardNumber;
	}

	public void setCrediCardNumber(String crediCardNumber) {
		CrediCardNumber = crediCardNumber;
	}
	
    public static OrdersBean findOrderbyId(int input_id) {
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    OrdersBean returnbean = db.DBgetOrderbyId(input_id);
   	    db.closeConnection();
   	    return returnbean;
    }
    
    public static ArrayList<OrdersBean> findOrderbyCustomerId(int input_id) {
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    ArrayList<OrdersBean> returnList = db.DBgetOrderbyCustomerId(input_id);
   	    db.closeConnection();
   	    return returnList;
    }
	
    public static OrdersBean addOrder(OrdersBean ordBean){
    	DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    OrdersBean ord = db.DBaddOrder(ordBean);
   	    db.closeConnection();
   	    return ord;
    }
    
    public static void decrementOrderTotal(int id, int subtract){
    	DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    db.DBdecrementOrderTotal(id, subtract);
   	    db.closeConnection();
    }
}
