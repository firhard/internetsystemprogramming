<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

th {

	text-align: left;
}

td {
	text-align: center;
}

table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
   
.Photo-Container  {
	float: right;	
}

}


</style>
<body>
<table>
	  <tr>
	    <th colspan="3">Product Name:</th>
	    <td>Adidas</td>
	  </tr>
	  <tr>
	  	<th colspan="3">Product Details:</th>
	  	<td>Raincoat Jacket</td>
	  </tr>
	  <tr>
	    <th colspan="3">Price:</th>
	    <td>$55</td>
	  </tr>
	  <tr>
	    <th colspan="3">Seller Name:</th>
	    <td>Firhard</td>
	  </tr>
	  <tr>
	    <th colspan="3">Available Quantity:</th>
	    <td>10</td>
	  </tr>
	  <tr>
	    <th colspan="3">Estimated Delivery Date:</th>
	    <td>July 25th, 2017</td>
	  </tr>
</table>
<div>
	<h2>Description</h2>
	<p>This is a really nice Jacket, it's really good.</p>
</div>
<div class="Photo-Container">
	<h2>Product Photos</h2>
	<a href="img/Adidas1.jpg">
		<img src="img/Adidas1.jpg" alt="Adidas image">
	</a>
	<a href="img/Adidas2.jpg">
		<img src="img/Adidas2.jpg" alt="Adidas image 2">
	</a>
</div>
<div>
	<h2>Questions & Answers</h2>
	<p><b>Q: RoboMaster09:</b> Is this a good Jacket?<p>
	<p><b>A: Samnsang54:</b> Yes you idiot</p>
	<p><b>Q: 50ShadesofWheels:</b> Is this better than the Nike Jacket<p>
	<p><b>A: HotOne44:</b> No....</p>
	<p><b>Q: MaxMaddHat:</b> How can I feed my kids</p>
	<p>This question has not been answered yet<p>
</div>
<div>
	<h2>Customer Reviews</h2>
	<p><b>Samnsang54:</b> This is a good jacket. I'm really happy at how smug I can be when I wear it.</p>
</div>
<br>
Home: <input type="button" value="Home" class="Home" name="Home" onclick="document.location.href='CustomerHomePage.jsp'"> <br>
Back: <input type="button" value="Back" class="Back" name="Back" onclick="document.location.href='ProductSearchResults.jsp'"> <br> 
Add to Cart: <input type="button" value="Add to Cart" class="Add to Cart" name="Add to Cart" onclick="document.location.href='View&CheckoutShoppingCart.jsp'"> <br>
Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'"> <br>
</body>
</html>