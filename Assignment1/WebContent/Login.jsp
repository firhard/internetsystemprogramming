<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<form action=Login method=get>
<c:if test="${isUserLoggedIn == true}">
	<c:redirect url="CustomerHomePage.jsp">
	</c:redirect>
	<br><br>
</c:if>
	Username:
	 <input type=text name=userName value= > <br>
	 <br>
	Password:
	<input type=password name=passWord value= > <br>
	 
	<input type=submit value=Submit> <br>
</form>

<form action=Registration.jsp method=get>
	<input type=submit value=Registration>
</form>
<%
	Integer applicationCount = (Integer)session.getAttribute("applicationCount");
    if (applicationCount == null) {
        applicationCount = new Integer(1);
    } else {
        applicationCount= new Integer(applicationCount.intValue() + 1);
    }
    session.setAttribute("applicationCount", applicationCount); %>
Visit Time:${applicationCount}<br>

</body>
</html>