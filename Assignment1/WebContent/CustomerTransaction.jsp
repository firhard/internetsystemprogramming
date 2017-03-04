<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
View Orders: <input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'"> <br>
Shopping Cart: <input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
<a href="ViewOrders.jsp">View Orders</a><br>

<div class="Products">
	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>Adidas Hot Fire Jacket</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Quantity:</th>
		  	<td>1</td>
		  </tr>
		  <tr>
		    <th colspan="3">Total Price:</th>
		    <td>$55</td>
		  </tr>
		  <tr>
		    <th colspan="3">Seller Name:</th>
		    <td>Firhard</td>
		  </tr>
	</table>
</div>


<div class="Products">
	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>Nike Extreme Weather Jacket</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Quantity:</th>
		  	<td>1</td>
		  </tr>
		  <tr>
		    <th colspan="3">Total Price:</th>
		    <td>$60</td>
		  </tr>
		  <tr>
		    <th colspan="3">Seller Name:</th>
		    <td>Jon</td>
		  </tr>
	</table>
</div>

<form action="CustomerTransactionConfirmation" method="post">
<div class="TransactionInfo">
	<table>
		<tr>
			<th>
				Price:<input type="hidden" name="insert" value="${product.getId()}">
			</th>
		</tr>
		<tr>
			<th>
				Card Holder Name:<input type="text" class="CardHolderName" name="Card Holder Name">
			</th> 
		</tr>
		<tr>
			<th>Card Type<select class="CardType" name="CardType">
				<option value="Visa">Visa</option>
				<option value="Mastercard">Master Card</option>
				<option value="Discover">Discover</option>
				<option value="AmericanExpress">American Express</option>
				</select>
			</th>
		</tr>
		<tr>
			<th>
				Card Number:<input type="text" class="CardNumber" name="Card Number">
			</th>
		</tr>
		<tr>
			<th>
				Security Code:<input type="text" class="SecurityCode" name="Security Code" style="width: 30px">
			</th>
		</tr>
		<tr>
			<th>
				Expiration Date (without the slash. e.g. 0717 for July 2017):<input type="text" class="ExpirationDate" name="Expiration Date" style="width: 30px">
			</th>
		</tr>
		<tr>
			<th>
				Billing Address:<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 7%"><br>
								<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 47%"><br>
								<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 47%"><br>
								<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 47%"><br>
			</th>
		</tr>
		<tr>
			<th>
				Checking Address:<input type="text" class="BillingAddress" name="Billing Address"><br>
								<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 47%"><br>
								<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 47%"><br>
								<input type="text" class="BillingAddress" name="Billing Address" style="margin-left: 47%"><br>
			</th>
		</tr>
	</table>
</div>
Confirm Payment: <input type="button" value="Confirm Payment" class="Confirm Payment" name="ConfirmPayment" onclick="document.location.href='CustomerTransactionConfirmation.jsp'"> <br>
</form>

Cancel Payment: <input type="button" value="Cancel Payment" class="Cancel Payment" name="CancelPayment" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>