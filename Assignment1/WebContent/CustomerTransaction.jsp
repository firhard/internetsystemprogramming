<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Transaction</title>
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
<div class="Products">
<c:forEach var="product" items="${ShoppingCart}" varStatus="status">
	<table>
		<tr>
			<th colspan="6">
				<a href="img/${product.getProductName()}.jpg">
					<img src="img/${product.getProductThumbnail()}.jpg" alt="Adidas image">
				</a>
			</th>			
		</tr>
  		<tr>
	    	<th colspan="3">Product Name:</th>
  			<td>${product.getProductName()} </td>			
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
				<th colspan="3">Requested Quantity:</th>
				<td>${RequestedQuantityList[status.index]}</td>
			</tr>
	</table><br>
	</c:forEach>
</div>

<div class="TransactionInfo">
	<table>
		<tr>
			<th>
				<h2>Total Price: $${TotalPrice}</h2>	
			</th>
		</tr>
		<tr>
			<th>
				Card Holder Name:<input type="text" id="CardHolderName" name="CardHolderName">
			</th> 
		</tr>
		<tr>
			<th>Card Type<select id="CardType" name="CardType">
				<option value="Visa">Visa</option>
				<option value="Master Card">Master Card</option>
				<option value="Discover">Discover</option>
				<option value="American Express">American Express</option>
				</select>
			</th>
		</tr>
		<tr>
			<th>
				Card Number:<input type="text" id="CardNumber" name="CardNumber">
			</th>
		</tr>
		<tr>
			<th>
				Security Code:<input type="text" id="SecurityCode" name="SecurityCode" style="width: 30px">
			</th>
		</tr>
		<tr>
			<th>
				Expiration Date (without the slash. e.g. 0717 for July 2017):<input type="text" id="ExpirationDate" name="ExpirationDate" style="width: 30px">
			</th>
		</tr>
		<tr>
			<th>
				Billing Address:<input type="text" id="BillingAddress" name="BillingAddress"><br>
			</th>
		</tr>
		<tr>
			<th>
				Shipping Address:<input type="text" id="ShippingAddress" name="ShippingAddress"><br>
			</th>
		</tr>
	</table>
</div>

</body>
</html>