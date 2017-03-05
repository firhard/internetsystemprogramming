package models;

import java.util.ArrayList;
import java.util.Collection;

public class OrdersBean {

	private int Id;
	private int CustomerId;
	private int TotalCost;
	private String OrderDate;
	private String ShippingAddress;
	private String BillingAddress;
	private String CrediCardNumber;
	private ArrayList<Integer> ProductsIds;

	public OrdersBean() {
		super();
		ProductsIds = new ArrayList<Integer>();
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
	
	
	
	
}
