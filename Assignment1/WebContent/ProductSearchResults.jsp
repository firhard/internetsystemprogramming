<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
Manage Orders: <input type="button" value="Manage Order" class="ManageOrder" name="Manage Order" onclick="document.location.href='ManageOrder.jsp'"> <br>

<table style="width:50%">
  <tr>
    <th>Product Name</th>
    <th>Product Category</th> 
    <th>Seller Name</th>
    <th>Price</th>
    <th>Thumbnail</th>
  </tr>
  <tr>
    <td>Adidas</td>
    <td>Sports</td> 
    <td>Firhard</td>
    <td>$99</td>
    <td><input type="button" value="Adidas" class="ProductDetails" name=" ProductDetails" onclick="document.location.href='ViewProductDetails.jsp'"></td>
  </tr>
  <tr>
    <td>Nike</td>
    <td>Sports</td> 
    <td>Jon</td>
    <td>$99</td>
    <td><input type="button" value="Nike" class="ProductDetails" name=" ProductDetails" onclick="document.location.href='ViewProductDetails.jsp'"></td>
  </tr>
</table>
Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'">

</body>
</html>