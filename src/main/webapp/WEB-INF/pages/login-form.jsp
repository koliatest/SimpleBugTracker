<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>

<title>Login page</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h1>Login page</h1>

<p>
<c:if test="${error == true}">
	<b class="error">Invalid login or password.</b>
</c:if>
</p>

<form class="form-signin" method="post" action="<c:url value='j_spring_security_check'/>" >
<table align="center">
<tbody>
<tr>
<h2 class="form-signin-heading"> <td>Login:</td> </h2>
<td><input class="form-control" type="text" name="j_username" id="j_username"size="30" maxlength="40"  /></td>
</tr>
<tr>
<td>Password:</td>
<td><input class="form-control" type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
</tr>
<tr>
<td></td>
<td><input class="btn btn-lg btn-primary btn-block" type="submit" value="Login" /></td>
</tr>
</tbody>
</table>
</form>	

<p>
<a href="${pageContext.request.contextPath}/index.html">Home page</a><br/>
</p>
</body>
</html>