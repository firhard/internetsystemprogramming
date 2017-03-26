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
<body id="bankResults">
<br>
<br>
<c:choose>
    <c:when test="${color eq 0}">
    	Your order has been a failure. Because the information that you inserted was incorrect
        <br />
    </c:when>  
    <c:when test="${color eq 2}">
    	Your order has been a failure. Because you have insufficient amount of balance
        <br />
    </c:when>
    <c:when test="${color eq 3}">
        Your order has been placed! The amount that you paid was $${TotalPrice}
        <script>
	        let elem = document.getElementById('buttons');
	        elem.style.display = 'none';
        </script>
		<input type="submit" value="print" onClick="window.print()"/> 
		<br>
		<div class="Products">
		<c:forEach var="product" items="${ShoppingCart}" varStatus="status">
			<table>
				<tr>
					<th colspan="6">
						<a href="img/${product.getProductName()}.jpg">
							<img src="img/${product.getProductThumbnail()}.jpg" alt="Adidas image">
						</a>
					</th>			
				</tr>
		  		<tr>
			    	<th colspan="3">Product Name:</th>
		  			<td>${product.getProductName()} </td>			
				</tr>
				<tr>
				  	<th colspan="3">Price:</th>
		  			<td>$${product.getPrice()*RequestedQuantityList[status.index]}</td>
				</tr>
				<tr>
				  	<th colspan="3">Seller Name:</th>
		  			<td>${product.findUserbySellerId(product.getSellerId()).getFullName()}</td>
				</tr>
					<tr>
						<th colspan="3">Requested Quantity:</th>
						<td>${RequestedQuantityList[status.index]}</td>
					</tr>
			</table><br>
			</c:forEach>
			${ShoppingCart[0].invalidateShoppingCart(Session)}
		</div>
    </c:when>  
	<c:otherwise>

	</c:otherwise>
</c:choose>
</body>
</html>