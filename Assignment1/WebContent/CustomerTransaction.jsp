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

<div class="Products">
	<table>
		<tr>
			<th>
				First Name:<input type="text" class="FirstName" name="First Name">
			</th> 
		</tr>
		<tr>
			<th>
				Last Name:<input type="text" class="LastName" name="Last Name"> 
			</th> 
		</tr>
		<tr>
			<th>Card Type<select>
				<option value="1">Visa</option>
				<option value="2">Master</option>
				<option value="3">Discover</option>
				<option value="4">American Express</option>
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
				Expiration Date:<input type="text" class="ExpirationDate" name="Expiration Date" style="width: 30px">
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
Cancel Payment: <input type="button" value="Cancel Payment" class="Cancel Payment" name="CancelPayment" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'"> <br>

</body>
</html>