<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="passWordInputValidation.js"></script>
<title>Registration</title>
</head>
<body>
<c:if test="${notregistered == false}">
	User is not registered. Please fill this form.<br>
</c:if>
<form name="myform" action=Registration method=get>

	Username:
	 <input type=text name=userName value= > <br>
	 
	Password:
	<input type=password id="pass1" name=passWord value= > <br>
	
	Re-Type Password:
	<input type=password id="pass2" name=passWord value= > <br>
	
	<input id="submit" type=submit value=Register>
</form>

<input type="button" value="Back to Login" onclick="document.location.href='Login.jsp'">

</body>
</html>