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
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
<form action="LogoutServlet" method="post">
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<input type="button" value="Manage Order" class="ManageOrder" name="Manage Order" onclick="document.location.href='ManageOrder.jsp'">
<input type ="Submit" name="Logout" value="Logout">
</form>
<form action=ViewOrdersServlet method="post"><input type="Submit" value="View Orders" name="View Orders"></form>
<br>
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
	  	<td><a href="img/${product.getProductThumbnail()}.jpg">
			<img src="img/${product.getProductThumbnail()}.jpg" alt="Adidas image"></a>
		</td>
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
  	 <h2>No Products Found</h2>
  </c:if>
<br>
 </body>
</html>