<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

  <%@include file="parts/bootstrap-part.jsp"%>

</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="formAdd">
<div class = "container">
  <div class="col-sm-6">
    <h1 class="header">Create a new project</h1>
    <sf:form id="myForm" cssClass="form-horizontal" method = "post" action="/project/create" modelAttribute = "dto">
      <div class="form-group">
        <nobr><label for="nameOfTheProject">Name of the project</label></nobr>
          <input type="text" class="form-control" id="nameOfTheProject" name="nameOfTheProject" placeholder="Name of the project">
      </div>


      <div class="form-group">
        <p><label>Lead of the project</label></p>
        <c:if test="${!empty userList}">
          <sf:select path="leadOfTheProject" cssClass="selectpicker" data-live-search="true">
            <c:forEach items="${userList}" var="user">
              <sf:option value="${user.id}">${user.firstName} ${user.lastName}</sf:option>
            </c:forEach>
          </sf:select>
        </c:if>
        <c:if test="${empty userList}">
          There are no users
        </c:if>
      </div>

    <div class="form-group">
      <nobr><label>Users in the current project</label></nobr>
      <textarea style="height: 150px;" class="form-control" id="usersInTheCurrentProject" name="usersInTheCurrentProject" placeholder="login1; login2; login3; login4;"></textarea>
    </div>

      <div class="form-group">
        <nobr><label for="descriptionOfTheProject">Description of the project</label></nobr>
          <textarea style="height: 170px;" class="form-control" id="descriptionOfTheProject" name="descriptionOfTheProject" placeholder="Description of the project"></textarea>
      </div>
      <div class="form-group">
          <button type="submit" class="btn btn-success btn-lg">Submit</button>
    </sf:form>
  </div>
</div>
</div>
</div>

<script src="<c:url value="/resources/js/disableSubmit.js" />" > </script>

<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>

</body>
</html>
