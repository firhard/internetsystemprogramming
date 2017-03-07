<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Order</title>
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
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<form action="LogoutServlet" method="post">
<input type ="Submit" name="Logout" value="Logout">
</form>

<c:forEach var="order" items="${OrdersList}">
	<div class="Products">
		<table>
			<tr>
				<th>
					Order Number:
				</th>
				<td>
					${order.getId()}
				</td>
			</tr>
			<tr>
				<th>
					Order Cost:
				</th>
				<td>
					${order.getTotalCost()}
				</td>
			</tr>
			<tr>
				<th>
					Order Date:
				</th>
				<td>
					${order.getOrderDate()}
				</td>
			</tr>
		</table>
		<form name="myOrder" action=ManageOrderServlet method=post>
	  		<input type="hidden" name="view" value="${order.getId()}">
	  		<input type=submit value="Manage Order" >
	  	</form>
	</div>
<button type="button" onclick="location = 'ManageOrder.jsp'">View</button><br>
 </c:forEach>


</body>
</html>