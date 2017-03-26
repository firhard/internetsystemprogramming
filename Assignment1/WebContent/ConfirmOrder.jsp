<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>

	function place_order_function(color){
		var fcardNumber =  $("#CardNumber").val();
		var fbillingAddress =  $("#BillingAddress").val();
		var fshippingAddress =  $("#ShippingAddress").val();
		  $.get("CustomerTransactionConfirmationServlet", {Color:color, cNumber:fcardNumber, billingAddress:fbillingAddress, shippingAddress:fshippingAddress}, function(data,status) {
	           window.location.reload();  	           
	  	  });
	}

	function confirm_function() {
		var fcardHolderName = $("#CardHolderName").val();
		var fcardType = $("#CardType").val();
		var fcardNumber =  $("#CardNumber").val();
		var fsecurityCode =  $("#SecurityCode").val();
		var fexpirationDate =  $("#ExpirationDate").val();
		var fbillingAddress =  $("#BillingAddress").val();
		var fshippingAddress =  $("#ShippingAddress").val();
        var ftotalPrice = $("body").attr("data-TotalPrice");
	       $.get("BankServlet", {TotalPrice:ftotalPrice, CardHolderName:fcardHolderName, CardType:fcardType, CardNumber:fcardNumber, SecurityCode:fsecurityCode, ExpirationDate:fexpirationDate}, function(data,status) {

		    	place_order_function(data);
	    	//success : place_order_function(data);
	  	  });
	  }
	
</script>
<title>Confirm Order</title>
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

<body data-TotalPrice="${TotalPrice}">
<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>

<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<form action="LogoutServlet" method="post">
<input type ="Submit" name="Logout" value="Logout">
</form>
<form action=ViewOrdersServlet method="post"><input type="Submit" value="View Orders" name="View Orders"></form>

<jsp:include page="CustomerTransaction.jsp" />
<div id="buttons">
	Confirm Payment: <input type="Submit" value="Confirm Payment" class="ConfirmPayment" name="ConfirmPayment" onclick="confirm_function()"> <br>
	Cancel Payment: <input type="button" value="Cancel Payment" class="CancelPayment" name="CancelPayment" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
</div>
<jsp:include page="CustomerTransactionConfirmation.jsp" />

</body>

</html>