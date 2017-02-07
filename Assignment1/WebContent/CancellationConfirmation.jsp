<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cancellation Confirmation</title>
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
Order Cancelled!<br>
Refundable Amount: $55 (no damage)<br>

Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'"> <br>


</body>
</html>