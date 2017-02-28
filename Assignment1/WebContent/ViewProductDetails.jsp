<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Products</title>
</head>
<style>

th {
	text-align: left;
}

td {
	text-align: center;
	padding: 5px;
}

table, th, td {
    border: 1px solid black;
    border-collapse: collapse;

}


</style>
<body>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
View Orders: <input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'"> <br>
Shopping Cart: <input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
<table>
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
	private Blob ProductThumbnail;
	  <tr>
	    <th colspan="3">Product Name:</th>
	    <td>${prodBean.productName}</td>
	  </tr>
	  <tr>
	    <th colspan="3">Price:</th>
	    <td>${prodBean.Price}</td>
	  </tr>
	  <tr>
	    <th colspan="3">Seller Name:</th>
	    <td>TODO: Insert Find User/Seller by Product</td>
	  </tr>
	  <tr>
	    <th colspan="3">Available Quantity:</th>
	    <td>${prodBean.AvailableQuantity}</td>
	  </tr>
	  <tr>
	    <th colspan="3">Estimated Delivery Date:</th>
	    <td>TODO: Add estimated delivery days in product table to current datetime</td>
	  </tr>
</table>
<div>
	<h2>Description</h2>
	<p>${prodBean.productDescription}</p>
</div>
<div>
	<h2>Product Photos</h2>
	<a href="img/${prodBean.productName }.jpg">
		<img src="img/Adidas1.jpg" alt="Adidas image">
	</a>
	<a href="img/Adidas2.jpg">
		<img src="img/Adidas2.jpg" alt="Adidas image 2">
	</a>
</div>
<div>
	<h2>Questions & Answers</h2>
	<p><b>Q: RoboMaster09:</b> Is this a good Jacket?<p>
	<p><b>A: Samnsang54:</b> Yes you idiot</p>
	<p><b>Q: 50ShadesofWheels:</b> Is this better than the Nike Jacket<p>
	<p><b>A: HotOne44:</b> No....</p>
	<p><b>Q: MaxMaddHat:</b> How can I feed my kids</p>
	<p>This question has not been answered yet<p>
</div>
<div>
	<h2>Customer Reviews (4.0 / 5.0 rating):</h2>
	<p><b>&nbsp; &nbsp;4 stars &nbsp; - &nbsp; &nbsp; June 25, 2015 &nbsp; - &nbsp; &nbsp; Samnsang54:</b> This is a good jacket. I'm really happy at how smug I can be when I wear it.</p>
</div>
<br>
Back: <input type="button" value="Back" class="Back" name="Back" onclick="document.location.href='ProductSearchResults.jsp'"> <br> 
Add to Cart: <input type="button" value="Add to Cart" class="Add to Cart" name="Add to Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>