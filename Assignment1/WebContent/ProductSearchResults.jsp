<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <c:forEach var="product" items="${ListName}" >
	  <tr>
	  	<td>${product.getProductName()}</td>
	  	<td>${product.getProductCategoryIndex()}</td>
	  	<td>${product.findUserbySellerId(product.getSellerId()).getFullName()}</td>
	  	<td>${product.getPrice()}</td>
	  	<td>${product.getProductThumbnail()}</td>
	  	<td>
		  	<form name="myProduct1" action=ProductSearchResultsServlet method=post>
		  		<input type="hidden" name="insert" value="${product.getId()}">
		  		<input type=submit value="View Product" >
		  	</form>
	  	</td>
	  </tr>
  </c:forEach>
</table>

<br>
 <c:if test="${empty ListName}">
  	 No Products Found
  </c:if>
 <br>
 
Logout:<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>
</body>
</html>