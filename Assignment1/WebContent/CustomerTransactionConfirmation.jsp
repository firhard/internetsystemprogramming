<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'">
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<a href="Logout"><input type ="submit" name="Log Out" value="Log Out"  ></a>

<a href="ViewOrders.jsp">View Orders</a><br>
Your order has been    
<c:choose>
    <c:when test="${color eq 0}">
    	<h2>a failure! Because the information that you insert was wrong.</h2>
        <br />
    </c:when>  
        <c:when test="${color eq 0}">
    	<h2>a failure! Because you have insufficient amount of balance</h2>
        <br />
    </c:when>          
	<c:otherwise>
		placed! The amount that you paid was ${price}
		<br>
		Card Holder Name: ${cardHolderName}
		CVV: ${sCode}
		Expiration Date: ${eDate}
		Confirmation Number: ${cNumber} 
	</c:otherwise>
</c:choose> 
</body>
</html>