<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View & Checkout Shopping Cart</title>
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
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'">
<form action="LogoutServlet" method="post">
<input type ="Submit" name="Logout" value="Logout">
</form>
<form action=ProductSearchResultsServlet method=post>
<div class="Products">
	<c:forEach var="product" items="${ShoppingCart}" varStatus="status">
		<table>
			<tr>
				<th colspan="3">
					<a href="img/${product.getProductName()}.jpg">
						<img src="img/${product.getProductThumbnail()}.jpg" alt="Adidas image">
					</a>
				</th>			
				<td colspan="3">
						<input type=submit value="Remove From Cart" name="Remove">
				</td>
			</tr>
	  		<tr>
		    	<th colspan="3">Product Name:</th>
	  			<td>${product.getProductName()} </td>			
			</tr>
			<tr>
			  	<th colspan="3">Products Detail:</th>
	  			<td>${product.getProductDescription() }</td>
			</tr>
			<tr>
			  	<th colspan="3">Price:</th>
	  			<td>$${product.getPrice()*RequestedQuantityList[status.index]}</td>
			</tr>
			<tr>
			  	<th colspan="3">Seller Name:</th>
	  			<td>${product.findUserbySellerId(product.getSellerId()).getFullName()}</td>
			</tr>
			<tr>
			  	<th colspan="3">Available Quantity:</th>
	  			<td>${product.getAvailableQuantity()}</td>
			</tr>
			<tr>
				<th colspan="3">Requested Quantity:</th>
				<td>${RequestedQuantityList[status.index]}</td>
			</tr>
			<tr>
			  	<th colspan="3">Estimated Delivery Date:</th>
	  			<td>${DateList[status.index]}</td>
			</tr>
		</table><br>
	</c:forEach>
</div>
	<br>
	
	<h2>Total Price: $${TotalPrice}</h2>
	<input type="button" value="Checkout" class="Checkout"><br>
	</form>
</body>
</html>