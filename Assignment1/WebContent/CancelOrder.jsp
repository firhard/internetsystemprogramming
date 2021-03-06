<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cancel Order</title>
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
<form action=CancelOrderTransactionServlet method=post>
 
<div class="Products">

	<table>
		  <tr>
		    <th colspan="3">Product Name:</th>
		    <td>${orderItem.findProductbyProductId(orderItem.getProductId()).getProductName()}</td>
		  </tr>
		   <tr>
		    <th colspan="3">Product Description:</th>
		    <td>${orderItem.findProductbyProductId(orderItem.getProductId()).getProductDescription()}</td>
		  </tr>
		  <tr>
		  	<th colspan="3">Product Quantity:</th>
		  	<td>${orderItem.getQuantity()}</td>
		  </tr>
		  <tr>
		    <th colspan="3">Total Price:</th>
		    <td><a name="price">$${orderItem.getProductPrice()*orderItem.getQuantity()}</a></td>
		  </tr>
		  <tr>
		    <th colspan="3">Seller Name:</th>
		    <td>${orderItem.findProductbyProductId(orderItem.getProductId()).findUserbySellerId(orderItem.getSellerId()).getFullName()}</td>
		   <tr>
		    <th colspan="3">Order Number:</th>
		    <td>${manageOrderBean.getId()}</td>
		  </tr>
		  
		  <tr>
		      <th colspan="3">Confirm Cancellation:</th>
			  <td>
			  		<input type="hidden" name="ConfirmSubmit" value="${orderItem.getId()}">
			  		<input type="hidden" name="ProductPrice" value="${orderItem.getProductPrice()*orderItem.getQuantity()}">
			  		<input type=submit value="Submit" >
			  </td>
		  </tr>
	</table>
</div>
</form>
<br>
Discard Cancellation: <input type="button" value="Discard Cancellation" class="DiscardCancellation" name="DiscardCancellation" onclick="document.location.href='ManageOrder.jsp'"> <br>
</body>
</html>