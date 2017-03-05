<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Order</title>
</head>
<style>
	html, body {
		width: 100%;
		height: 100%;
		}
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
	
	table {
		margin: 5px;
	}
	
	
	.Products {
		display:flex;
		margin: 5px;
	}
	
	div form {
		margin: 10px;
	}
	
	.Total p {
		padding: 0px;
		margin: 0px;
	}
	
	
	.Sub_Total p{
		padding: 0px 0px 0px 20px;
	}
</style>
<body>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
View Orders: <input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'"> <br>
Shopping Cart: <input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>

<h2>Order Number ${manageOrderBean.getId()}</h2>

<c:forEach var="product" items="${prodOrderList}">
	<div class="Products">
		<table>
			<tr>
				<th>Product name</th>
				<td>${product.getProductName()}</td>
			</tr>
			<tr>
				<th>Product quantity</th>
				<td>${product.getQuantity()}</td>
			</tr>
			<tr>
				<th>Total price</th>
				<td>${product.getPrice}</td>
			</tr>
			<tr>
				<th>Seller name</th>
				<td>${product.findUserbySellerId(product.getSellerId()).getFullName()}</td>
			</tr>
			<tr>
				<th>Shipping status</th>
					<td>Active</td>
			</tr>
			<tr>
				<th>View</th>
					<td>View: <input type="button" value="View Product Details" class="ViewProductDetails" name="View Product Details" onclick="document.location.href='ViewProductDetails.jsp'"></td>
			</tr>
			<tr>
				<th>Cancel</th>
					<td>Cancel Order: <input type="button" value="Cancel Order" class="CancelOrder" name="Cancel Order" onclick="document.location.href='CancelOrder.jsp'"></td>
			</tr>
	</table>	
	</div>
</c:forEach>
<br>
<br>
<table>
		<tr>
			<th>Order Total:</th>
			<td>$155</td>
		</tr>
		<tr>
			<th>
				Order Date:
			</th>
			<td>
				January 19, 2017
			</td>
		</tr>		
		<tr>
			<th>Shipping Address:</th>
			<td>White House</td>
		</tr>
</table>
	
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>