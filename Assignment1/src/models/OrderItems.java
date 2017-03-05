package models;

public class OrderItems {

	
	private int Id;
	private int OrderId;
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
}
