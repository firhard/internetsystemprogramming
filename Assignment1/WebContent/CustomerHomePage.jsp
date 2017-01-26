<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
View Orders: <input type="button" value="View Orders" class="ViewOrders" name="View Orders" onclick="document.location.href='ViewOrders.jsp'"> <br>

Product Categories<select>
	<option value="1">one</option>
	<option value="2">two</option>
	<option value="3">three</option>
	<option value="4">four</option>
	</select><br>
	
Search: <input type="text" class="Search" name="Search"><input type="submit" value="Submit" onclick= "document.location.href='ProductSearchResults.jsp'"><br>

Logout: <input type="button" value="Logout" class="Logout" name="Logout" onclick="document.location.href='Login.jsp'">
</body>
</html>