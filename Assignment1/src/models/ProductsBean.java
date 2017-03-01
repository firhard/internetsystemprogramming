package models;

import java.sql.Blob;


public class ProductsBean {
	
	
	private int Id;
	private String ProductName;
	private int ProductCategoryIndex;
	private Blob ProductDescription;
	private int Price;
	private int AvailableQuantity;
	private int EstimatedDeliveryDays;
	private int SellerId;
	private Blob ProductPhotosLinks;
	private Blob ProductVideosLinks;
	private String ProductThumbnail;

	public ProductsBean() {
		super();
	}
	
	public ProductsBean(int Id, String ProductName, int ProductCategoryIndex, 
			Blob ProductDescription, int Price, int AvailableQuantity, 
			int EstimatedDeliveryDays, int SellerId, Blob ProductPhotosLinks,  
			Blob ProductVideosLinks, Blob ProductThumbnail){
		
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getProductName() {
		return(ProductName);
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public int getProductCategoryIndex() {
		return ProductCategoryIndex;
	}

	public void setProductCategoryIndex(int productCategoryIndex) {
		ProductCategoryIndex = productCategoryIndex;
	}

	public Blob getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(Blob productDescription) {
		ProductDescription = productDescription;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getAvailableQuantity() {
		return AvailableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		AvailableQuantity = availableQuantity;
	}

	public int getEstimatedDeliveryDays() {
		return EstimatedDeliveryDays;
	}

	public void setEstimatedDeliveryDays(int estimatedDeliveryDays) {
		EstimatedDeliveryDays = estimatedDeliveryDays;
	}

	public int getSellerId() {
		return SellerId;
	}

	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}

	public Blob getProductPhotosLinks() {
		return ProductPhotosLinks;
	}

	public void setProductPhotosLinks(Blob productPhotosLinks) {
		ProductPhotosLinks = productPhotosLinks;
	}

	public Blob getProductVideosLinks() {
		return ProductVideosLinks;
	}

	public void setProductVideosLinks(Blob productVideosLinks) {
		ProductVideosLinks = productVideosLinks;
	}

	public String getProductThumbnail() {
		return ProductThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		ProductThumbnail = productThumbnail;
	}
	
    public static ProductsBean findProductbyId(int input_id) {
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    ProductsBean return_id = db.DBgetProductbyId(input_id);
   	    db.closeConnection();
   	
   	    return return_id;
    }

    public String search(String ProductName) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	String product = db.productName(ProductName);
	   	db.closeConnection();
	   	return product;
    }
	
}
