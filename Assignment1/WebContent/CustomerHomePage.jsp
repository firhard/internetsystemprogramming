<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
<form action=ViewOrdersServlet method="post"><input type="Submit" value="View Orders" name="View Orders"></form>
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<form action=LogoutServlet method="post"><input type ="Submit" name="Logout" value="Logout"></form>
<br>
<form action="ProductSearchQuery" method="post">
Product Categories<select name="Category">
	<option value="${category}">${category}</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	</select><br>
Search: <input type="text" class="Search" name="Search" value="${search}"><input type="submit" value="Submit"><br>

</form>
<form action=ClientAccessCount method="post">
Visit Time:${countString}<br>
</form>

<p> Last Successful Login: ${timeStamp}</p>
</body>
</html>