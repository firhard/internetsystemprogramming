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
	function addToCart() {
		//var firstName = $("#fName").val();
		//var lastName  = $("#lName").val();
        var productId = $("table").attr("data-ProductId");
        var requestedQuantity = $("#ProductQuantity").val(); //document.getElementsByClassName("ProductQuantity");
        //var productTable = document.getElementById('product');
        //var productId = productTable.getAttribute('data-ProductId');
	   
	       $.get("UpdateShoppingCart", {ProductQuantitySend:requestedQuantity, ProductIdSend:productId}, function(data,status) {
	    		if(data == 1) {	
			        alert("Succeeded in adding item");
				} else if(data == -1) {	    			
	    			alert("Failed to add item");
	    		}
				else {
					alert("Unknown error");
				}		
	  	  });
	  }
	
	function addQuestion() {
        var productId = $("table").attr("data-ProductId");
        var question = $("#question").val();

       $.get("QAServlet", {QuestionSend:question, ProductIdSend:productId}, function(data,status) {
    		
           window.location.reload();
	  	  });
	 }
    
	function addReview() {
        var productId = $("table").attr("data-ProductId");
        var freview = $("#review").val();
        var frating = $("#rating").val();

       $.get("CustomerReviewServlet", {ReviewSend:freview, RatingSend:frating, ProductIdSend:productId}, function(data,status) {
    		
           window.location.reload();
	  	  });
	 }
</script>
<title>View Products</title>
</head>
<style>

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


</style>
<body>

<c:if test="${isUserLoggedIn == null || isUserLoggedIn == false}">
	<c:redirect url="Login.jsp">
	</c:redirect>
</c:if>
		
<form action="LogoutServlet" method="post">
<input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'">
<input type="button" value="Back" class="Back" name="Back" onclick="document.location.href='ProductSearchResults.jsp'"> 
<input type="button" value="Shopping Cart" class="Shopping Cart" name="Shopping Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'">
<input type ="Submit" name="Logout" value="Logout">
</form>

<form action=ViewOrdersServlet method="post"><input type="button" value="View Orders" name="View Orders"></form>

<br><br>
<table id="product" data-ProductId="${prodBean.getId()}">
	<tr>
	    <th>Product Name:</th>
	    <th>Price:</th> 
	    <th>Seller Name:</th>
	    <th>Available Quantity:</th>
	    <th>Estimated Delivery Date:</th>
	</tr>
  	<tr>
	    <td>${prodBean.getProductName()}</td>
	    <td>$${prodBean.getPrice()}</td>
	    <td>${prodBean.findUserbySellerId(prodBean.getSellerId()).getFullName()}</td>
	    <td>${prodBean.getAvailableQuantity()}</td>
    	<td>${prodBean.getEstimatedDeliveryDays()}</td>
    </tr>
</table>
Add to Cart:<input type="text" id="ProductQuantity" name="ProductQuantity"><input type="submit" value="Submit" value="Add to Cart" onclick="addToCart()">
<br>
<div>
	<h2>Product Photos</h2>
	<a href="img/${prodBean.getProductPhotosLinks()}1.jpg">
		<img src="img/${prodBean.getProductPhotosLinks()}1.jpg" alt="Adidas image">
	</a>
	<a href="img/${prodBean.getProductPhotosLinks()}2.jpg">
		<img src="img/${prodBean.getProductPhotosLinks()}2.jpg" alt="Adidas image 2">
	</a>
</div>
<div>
	<h2>Products Description</h2>
	<p>${prodBean.getProductDescription()}</p>
</div>

<br>
<div>
	<h2>Questions & Seller Answers</h2>
	<c:forEach var="QA" items="${QuestionList}">
		<p><b>Q: ${QA.findUserbyUserId(QA.getCustomerId()).getUserName()}:</b> ${QA.getQuestion()}<p>
		<p><b>A: ${prodBean.findUserbySellerId(prodBean.getSellerId()).getFullName()}:</b> ${QA.getAnswer() eq '' || QA.getAnswer() eq ' ' || QA.getAnswer() eq null ? "No seller response" : QA.getAnswer()}</p>
	</c:forEach>
	<br>
	<h2>Ask a question</h2>
	Your Question:
	<input type=text id="question" > <br>
	<input type=submit value=Submit onClick="addQuestion()"> <br>
	
</div>
<div>
	<h2>Customer Reviews:</h2>
	<c:forEach var="Review" items="${ReviewList}">
		<p><b>&nbsp; &nbsp;${Review.getRating()} &nbsp; - &nbsp; &nbsp; ${Review.getReviewDate()} &nbsp; - &nbsp; &nbsp; ${Review.findUserbyUserId(Review.getCustomerId()).getUserName()}:</b> ${Review.getReview()}</p>
	</c:forEach>
	<br>
	<h2>Submit a review</h2>
	Rating (1-5):
	 <input type=text id="rating" > <br>
	 <br>
	Review:
	<input type=text id="review" > <br>
	<input type=submit value=Submit onClick="addReview()"> <br>
	
</div>
</body>
</html>