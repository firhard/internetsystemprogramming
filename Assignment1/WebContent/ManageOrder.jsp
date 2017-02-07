<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="Products">
		<table>
			<tr>
				<th>
					Order Number:
				</th>
				<td colspan="2">2</td>
			</tr>
			<tr>
				<th>Product name</th>
					<td>Adidas Hot Fire Jacket</td>
					<td>Nike Extreme Weather Jacket</td>
			</tr>
			<tr>
				<th>Product quantity</th>
					<td>1</td>
					<td>1</td>
					</tr>
			<tr>
				<th>Total price</th>
					<td>$55</td>
					<td>$60</td>
			</tr>
			<tr>
				<th>Seller name</th>
					<td>Firhard</td>
					<td>Jon</td>
			</tr>
			<tr>
				<th>Shipping status</th>
					<td>Active</td>
					<td>Active</td>
			</tr>
			<tr>
				<th>View</th>
					<td>View: <input type="button" value="View Product Details" class="ViewProductDetails" name="View Product Details" onclick="document.location.href='ViewProductDetails.jsp'"></td>
					<td>View: <input type="button" value="View Product Details" class="ViewProductDetails" name="View Product Details" onclick="document.location.href='ViewProductDetails.jsp'"></td>
			</tr>
			<tr>
				<th>Cancel</th>
					<td>Cancel Order: <input type="button" value="Cancel Order" class="CancelOrder" name="Cancel Order" onclick="document.location.href='CancelOrder.jsp'"></td>
					<td>Cancel Order: <input type="button" value="Cancel Order" class="CancelOrder" name="Cancel Order" onclick="document.location.href='CancelOrder.jsp'"></td>
			</tr>		
			<tr>
				<th>Order Total:</th>
				<td colspan="2">$155</td>
			</tr>
			<tr>
				<th>
					Order Date:
				</th>
				<td colspan="2">
					January 19, 2017
				</td>
			</tr>		
			<tr>
				<th>Shipping Address:</th>
				<td colspan="2">White House</td>
			</tr>
		</table>
	</div>
View Orders: <input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'"> <br>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'"> <br>
</body>
</html>