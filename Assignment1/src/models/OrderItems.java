package models;

import java.util.ArrayList;

public class OrderItems {

	
	private int Id;
	private int OrderId;
	private int SellerId;
	private int ProductId;
	private int ProductPrice;
	private int Quantity;
	private byte ShippingStatus;
	private int ShippingRefNo;
	private byte Status;

	public OrderItems() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public int getSellerId() {
		return SellerId;
	}

	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public byte getShippingStatus() {
		return ShippingStatus;
	}

	public void setShippingStatus(byte shippingStatus) {
		ShippingStatus = shippingStatus;
	}

	public int getShippingRefNo() {
		return ShippingRefNo;
	}

	public void setShippingRefNo(int shippingRefNo) {
		ShippingRefNo = shippingRefNo;
	}

	public byte getStatus() {
		return Status;
	}

	public void setStatus(byte status) {
		Status = status;
	}
	
    public static ArrayList<OrderItems> findOrderItemsbyOrderId(int id) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	ArrayList<OrderItems> OrderItems = db.DBgetOrderItemsbyOrderID(id);
	   	db.closeConnection();
	   	return OrderItems;
    }
    
    public static OrderItems findOrderItembyOrderItemId(int input_id) {
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    OrderItems OrderItem = db.DBgetOrderItembyOrderItemId(input_id);
   	    db.closeConnection();
   	    return OrderItem;
    }
    
    public static boolean verifyShipmentStatus(int input_id){
    	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	boolean verified = db.DBverifyShipment(input_id);
	   	return verified;
    }
    
	public ProductsBean findProductbyProductId(int id) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	ProductsBean product = db.DBgetProductbyId(id);
	   	db.closeConnection();
	   	return product;
    }

	public static OrderItems dropOrderItembyOrderItemId(int orderItemId) {
		DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	OrderItems orderItem = db.DBDeleteOrderItem(orderItemId);
	   	db.closeConnection();
		return orderItem;
	}

}
