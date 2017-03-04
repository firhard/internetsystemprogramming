package models;

import java.util.ArrayList;

public class ProductsBean {
	
	
	private int Id;
	private String ProductName;
	private int ProductCategoryIndex;
	private String ProductDescription;
	private int Price;
	private int AvailableQuantity;
	private int EstimatedDeliveryDays;
	private int SellerId;
	private String ProductPhotosLinks;
	private String ProductVideosLinks;
	private String ProductThumbnail;

	public ProductsBean() {
		super();
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

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
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

	public String getProductPhotosLinks() {
		return ProductPhotosLinks;
	}

	public void setProductPhotosLinks(String productPhotosLinks) {
		ProductPhotosLinks = productPhotosLinks;
	}

	public String getProductVideosLinks() {
		return ProductVideosLinks;
	}

	public void setProductVideosLinks(String productVideosLinks) {
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

    public static ArrayList<ProductsBean> findProductbyName(String ProductName) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	ArrayList<ProductsBean> product = db.DBgetProductsbyName(ProductName);
	   	db.closeConnection();
	   	return product;
    }
    
    public static ArrayList<ProductsBean> findProductbyNameandCategory(String ProductName, int Category) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	ArrayList<ProductsBean> product = db.DBgetProductsbyNameandCategory(ProductName, Category);
	   	db.closeConnection();
	   	return product;
    }
    
	public Users findUserbySellerId(int id) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	Users user = db.DBgetUserbyId(id);
	   	db.closeConnection();
	   	return user;
    }
    
	
}
