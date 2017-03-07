<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'">
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
<form action="LogoutServlet" method="post">
<input type ="Submit" name="Logout" value="Logout">
</form>
<h2>Order Number ${manageOrderBean.getId()}</h2>

<c:forEach var="orderItem" items="${orderList}">
	<div class="Products">
		<table>
			<tr>
				<th>Product name</th>
				<td>${manageOrderBean.findProductbyProductId(orderItem.getProductId()).getProductName()}</td>
			</tr>
			<tr>
				<th>Product quantity</th>
				<td>${orderItem.getQuantity()}</td>
			</tr>
			<tr>
				<th>Total price</th>
				<td>${orderItem.getProductPrice()}</td>
			</tr>
			<tr>
				<th>Seller name</th>
				<td>${manageOrderBean.findProductbyProductId(orderItem.getProductId()).findUserbySellerId(product.getSellerId()).getFullName()}</td>
			</tr>
			<tr>
				<th>Shipping status</th>
				<td>orderItem.getShippingStatus()</td>
			</tr>
			<tr>

				<th>View</th>
				<td>
					<form action=ProductSearchResultsServlet method=post>
				  		<input type="hidden" name="insert" value="${orderItems.getProductId()}">
				  		<input type=submit value="Cancel Order" >
			  		</form>
			  	</td>
			</tr>
			<tr>
				<th>Cancel</th>
				<td>	
					<form action=CancelOrderServlet method=post>
				  		<input type="hidden" name="orderId" value="${manageOrderBean.getId()}">
				  		<input type="hidden" name="orderItemsId" value="${orderItems.getId()}">
				  		<input type=submit value="Cancel Order" >
			  		</form>
			  	</td>
			</tr>
	</table>	
	</div>
</c:forEach>
<br>
<br>
<table>
		<tr>
			<th>Order Total:</th>
			<td>${manageOrderBean.getTotalCost() }</td>
		</tr>
		<tr>
			<th>
				Order Date:
			</th>
			<td>${manageOrderBean.getOrderDate()}</td>
		</tr>		
		<tr>
			<th>Shipping Address:</th>
			<td>${manageOrderBean.getShippingAddress()}</td>
		</tr>
</table>
</body>
</html>