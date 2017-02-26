<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Transaction Confirmation</title>
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
Your order has been placed!

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
			<th> First Name: Donald </th> 
		</tr>
		<tr>
			<th>Last Name: Trump </th> 
		</tr>
		<tr>
			<th>Billing Address: White House</th>
		</tr>
		<tr>
			<th>Checking Address: Trump Tower</th>
		</tr>
	</table>
</div>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br><br>
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>