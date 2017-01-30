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


div {
	display:flex;
	margin: 5px;
}

div form {
	margin: 10px;
}


</style>
<body>
<div>
	<a class="thumbnail" href="img/Adidas3.jpg">
		<img src="img/Adidas3.jpg" alt="Adidas image">
	</a>
	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>Adidas</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Details:</th>
		  	<td>Raincoat Jacket</td>
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

<div>
	<a href="img/Nike1.jpg">
		<img src="img/Nike1.jpg" alt="Nike image">
	</a>
	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>Nike</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Details:</th>
		  	<td>Nike Jacket</td>
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

Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'"> <br>
</body>
</html>