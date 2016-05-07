
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>

  <%@include file="parts/bootstrap-part.jsp"%>

</head>
<body>
<div class = "container">
  <div class="col-sm-6">
    <h1 class="header">Registration</h1>
  <sf:form cssClass="form-horizontal" method = "post" action="registration" modelAttribute = "user">
    <div class="form-group">
      <nobr><label for="login" class="col-sm-2 control-label">First Name</label></nobr>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name">
      </div>
    </div>
    <div class="form-group">
      <nobr><label for="login" class="col-sm-2 control-label">Last Name</label></nobr>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
      </div>
    </div>
  <div class="form-group">
      <label for="login" class="col-sm-2 control-label">Login</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="login" name="login" placeholder="Login">
      </div>
  </div>
    <div class="form-group">
      <label for="login" class="col-sm-2 control-label">Email</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" name="email" placeholder="email">
      </div>
    </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">Submit</button>
    </div>
    </sf:form>
  </div>
  </div>
  </div>

<script src="<c:url value="/resources/js/registration.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>

</body>
</html>
