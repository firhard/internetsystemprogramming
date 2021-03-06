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
<form action="LogoutServlet" method="post">
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<input type ="Submit" name="Logout" value="Logout">
</form>
<form action=ViewOrdersServlet method="post"><input type="Submit" value="View Orders" name="View Orders"></form>
<br>
<h2>Order Number ${manageOrderBean.getId()}</h2>

	<div class="Products">
	<c:forEach var="orderItem" items="${orderItemsList}">
		<table>
			<tr>
				<th>Product name</th>
				<td>${orderItem.findProductbyProductId(orderItem.getProductId()).getProductName()}</td>
			</tr>
			<tr>
				<th>Product quantity</th>
				<td>${orderItem.getQuantity()}</td>
			</tr>
			<tr>
				<th>Total Price</th>
				<td>$${orderItem.getProductPrice()*orderItem.getQuantity()}</td>
			</tr>
			<tr>
				<th>Seller name</th>
				<td>${orderItem.findProductbyProductId(orderItem.getProductId()).findUserbySellerId(orderItem.getSellerId()).getFullName()}</td>
			</tr>
			<tr>
				<th>Shipping status</th>
				<td>${orderItem.getShippingStatus()}</td>
			</tr>
			<tr>

				<th>Product Details</th>
				<td>
					<form action=ProductSearchResultsServlet method=post>
				  		<input type="hidden" name="insert" value="${orderItem.getProductId()}">
				  		<input type=submit value="Details" >
			  		</form>
			  	</td>
			</tr>
			<c:if test="${orderItem.getShippingStatus() == 1 && orderItem.getStatus() == 1}">
				<tr>
					<th>Cancel</th>
					<td>	
						<form action=CancelOrderServlet method=post>
					  		<input type="hidden" name="orderId" value="${manageOrderBean.getId()}">
					  		<input type="hidden" name="orderItemsId" value="${orderItem.getId()}">
					  		<input type=submit value="Cancel Order" >
				  		</form>
				  	</td>
				</tr>
			</c:if>
			<c:if test="${orderItem.getStatus() == 0}">
				<tr>
					<th>Cancel</th>
					<td>	
						<h2>Cancelled</h2>
				  	</td>
				</tr>
			</c:if>
	</table>
	</c:forEach>	
	</div>
<br>
<br>
<table>
		<tr>
			<th>Order Total:</th>
			<td>$${manageOrderBean.getTotalCost() }</td>
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