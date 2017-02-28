<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
View Orders: <input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'"> <br>
Shopping Cart: <input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
Manage Orders: <input type="button" value="Manage Order" class="ManageOrder" name="Manage Order" onclick="document.location.href='ManageOrder.jsp'"> <br>

<table style="width:50%">
  <tr>
    <th>Product Name</th>
    <th>Product Category</th> 
    <th>Seller Name</th>
    <th>Price</th>
    <th>Thumbnail</th>
  </tr>
  <tr>
  	<td>${Products[0].ProductName}</td>
  	<td>${Products[0].ProductCategory}</td>
  	<td>${Products[0].SellerName}</td>
  	<td>${Products[0].Price}</td>
  	<td>${Products[0].Thumbnail}</td>
  	<td>
	  	<form name="myProduct1" action=ProductSearchResultsServlet method=post>
	  		<input name="${Products[0].Id}" id="submit" type=submit value="View Product" >
	  	</form>
  	</td>
  </tr>
    <tr>
  	<td>${Products[1].ProductName}</td>
  	<td>${Products[1].ProductCategory}</td>
  	<td>${Products[1].SellerName}</td>
  	<td>${Products[1].Price}</td>
  	<td>${Products[1].Thumbnail}</td>
  	<td>
	  	<form name="myProduct2" action=ProductSearchResultsServlet method=post>
	  		<input name="${Products[1].Id}" id="submit" type=submit value="View Product" >
	  	</form>
  	</td>
  	</tr>
  <tr>
    <td>Adidas Jacket</td>
    <td>Sports</td> 
    <td>Firhard</td>
    <td>$99</td>
    <td><input type="button" value="Adidas" class="ProductDetails" name="ProductDetails" onclick="document.location.href='ViewProductDetails.jsp'"></td>
  </tr>
  <tr>
    <td>Nike Jacket</td>
    <td>Sports</td>
    <td>Jon</td>
    <td>$99</td>
    <td><input type="button" value="Nike" class="ProductDetails" name="ProductDetails" onclick="document.location.href='ViewProductDetails.jsp'"></td>
  </tr>
</table>
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>