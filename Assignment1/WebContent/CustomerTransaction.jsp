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
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>

<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<form action="LogoutServlet" method="post">
<input type ="Submit" name="Logout" value="Logout">
</form>
<form action=ViewOrdersServlet method="post"><input type="Submit" value="View Orders" name="View Orders"></form>

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

<form action="CustomerTransactionConfirmationServlet" method="post">
<div class="TransactionInfo">
	<table>
		<tr>
			<th>
				<h2>Total Price: $${TotalPrice}</h2>	
			</th>
		</tr>
		<tr>
			<th>
				Card Holder Name:<input type="text" class="CardHolderName" name="CardHolderName">
			</th> 
		</tr>
		<tr>
			<th>Card Type<select class="CardType" name="CardType">
				<option value="Visa">Visa</option>
				<option value="Master Card">Master Card</option>
				<option value="Discover">Discover</option>
				<option value="American Express">American Express</option>
				</select>
			</th>
		</tr>
		<tr>
			<th>
				Card Number:<input type="text" class="CardNumber" name="CardNumber">
			</th>
		</tr>
		<tr>
			<th>
				Security Code:<input type="text" class="SecurityCode" name="SecurityCode" style="width: 30px">
			</th>
		</tr>
		<tr>
			<th>
				Expiration Date (without the slash. e.g. 0717 for July 2017):<input type="text" class="ExpirationDate" name="ExpirationDate" style="width: 30px">
			</th>
		</tr>
		<tr>
			<th>
				Billing Address:<input type="text" class="BillingAddress" name="BillingAddress"><br>
			</th>
		</tr>
		<tr>
			<th>
				Shipping Address:<input type="text" class="ShippingAddress" name="ShippingAddress"><br>
			</th>
		</tr>
	</table>
</div>
Confirm Payment: <input type="Submit" value="Confirm Payment" class="ConfirmPayment" name="ConfirmPayment"> <br>
Cancel Payment: <input type="button" value="Cancel Payment" class="CancelPayment" name="CancelPayment"  onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
</form>
</body>
</html>