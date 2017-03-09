<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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

<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
<form action="LogoutServlet" method="post">
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="Back" class="Back" name="Back" onclick="document.location.href='ProductSearchResults.jsp'"> 
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<input type ="Submit" name="Logout" value="Logout">
</form>

<form action=ViewOrdersServlet method="post"><input type="Submit" value="View Orders" name="View Orders"></form>

<br><br><form action="UpdateShoppingCart" method="post">
<table>
	<tr>
	    <th>Product Name:</th>
	    <th>Price:</th> 
	    <th>Seller Name:</th>
	    <th>Available Quantity:</th>
	    <th>Estimated Delivery Date:</th>
	</tr>
  	<tr>
	    <td>${prodBean.getProductName()}</td>
	    <td>${prodBean.getPrice()}</td>
	    <td>${prodBean.findUserbySellerId(prodBean.getSellerId()).getFullName()}</td>
	    <td>${prodBean.getAvailableQuantity()}</td>
    	<td>${prodBean.getEstimatedDeliveryDays()}</td>
    </tr>
</table>
Add to Cart:<input type="text" class="ProductQuantity" name="ProductQuantity"><input type="submit" value="Submit" value="Add to Cart">
<br>
<div>
	<h2>Product Photos</h2>
	<a href="img/${prodBean.getProductPhotosLinks()}1.jpg">
		<img src="img/${prodBean.getProductPhotosLinks()}1.jpg" alt="Adidas image">
	</a>
	<a href="img/${prodBean.getProductPhotosLinks()}2.jpg">
		<img src="img/${prodBean.getProductPhotosLinks()}2.jpg" alt="Adidas image 2">
	</a>
</div>
<div>
	<h2>Products Description</h2>
	<p>${prodBean.getProductDescription()}</p>
</div>

</form><br>
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
</body>
</html>