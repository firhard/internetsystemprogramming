<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<form action=ProductSearchResultsServlet method=post>
<div class="Products">
	<a class="thumbnail" href="img/Adidas3.jpg">
		<img src="img/Adidas3.jpg" alt="Adidas image">
	</a>
	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>Adidas Hot Fire Jacket</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Details:</th>
		  	<td>Adidas Raincoat Jacket</td>
		  </tr>
		  <tr>
		    <th colspan="3">Price:</th>
		    <td>$55</td>
		  </tr>
		  <tr>
		    <th colspan="3">Seller Name:</th>
		    <td>Firhard</td>
		  </tr>
		  <tr>
		    <th colspan="3">Available Quantity:</th>
		    <td>10</td>
		  </tr>
		  <tr>
		    <th colspan="3">Estimated Delivery Date:</th>
		    <td>July 25th, 2017</td>
		  </tr>
	</table>
	<form action=>
		<input type=submit value="Remove From Cart"> <br> 
	</form>
</div>

<div class="Products">
	<a href="img/Nike1.jpg">
		<img src="img/Nike1.jpg" alt="Nike image">
	</a>
	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>Nike Extreme Weather Jacket</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Details:</th>
		  	<td>Nike Raincoat Jacket</td>
		  </tr>
		  <tr>
		    <th colspan="3">Price:</th>
		    <td>$60</td>
		  </tr>
		  <tr>
		    <th colspan="3">Seller Name:</th>
		    <td>Jonathan</td>
		  </tr>
		  <tr>
		    <th colspan="3">Available Quantity:</th>
		    <td>6</td>
		  </tr>
		  <tr>
		    <th colspan="3">Estimated Delivery Date:</th>
		    <td>July 11th, 2017</td>
		  </tr>
	</table>
	<form action=>
		<input type=submit value="Remove From Cart"> <br> 
	</form>
</div>
<div class="Total">
	<br>
	<h3>Total Cost:	</h3>
	<div class="Sub_Total">
		<p><b>Adidas Hot Fire Jacket: $55.00</b></p>
		<p><b>Nike Extreme Weather Jacket: $60.00</b></p>
	</div>
	<p><b>+____________________________________</b>
	<div class="Sub_Total"><p><b>$115.00</b></p></div>
</div>
<br>
Checkout <input type="button" value="Checkout" class="Checkout"><br>
</form>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>