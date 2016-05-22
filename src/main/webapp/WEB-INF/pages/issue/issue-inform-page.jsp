<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>

  <%@include file="../parts/bootstrap-part.jsp"%>

</head>
<body>

<%@include file="../parts/header.jsp"%>

<div class="container body-content">
  <div class="row">

    <div class="col-md-6">
      <div class="formAdd">
        <div class = "container">
          <div class="col-sm-6">
            <h1 class="header">Information of the issue</h1>
            <div style="margin-left: 395px;">
              <a href="/issue/update/${currentIssue.id}" class="btn btn-warning">Edit</a>
              <button type="button" class="btn btn-danger" onclick="checkDelete(${currentIssue.id})">Delete</button>
            </div>
            <sf:form id="myForm" cssClass="form-horizontal" method = "post" modelAttribute = "dto">

            <div class="form-group">
              <p><label>Project</label></p>
              <input type="text" class="form-control" value="${currentIssue.projectOfTheIssue.nameOfTheProject}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>Title of issue</label></nobr>
              <input type="text" class="form-control" value="${currentIssue.titleOfIssue}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>Date of creation</label></nobr>
              <c:set var="dateOfCreation" value="${currentIssue.dateOfTheCreation}" />
              <input type="text" class="form-control" value="<fmt:formatDate type="both" value="${dateOfCreation}" />" readonly>
            </div>

            <div class="form-group">
              <nobr><label>Description</label></nobr>
              <textarea style="height: 150px;" class="form-control" readonly>${currentIssue.description}</textarea>
            </div>

            <div class="form-group">
              <p><label>Priority</label></p>
              <input type="text" class="form-control" value="${currentIssue.priority}" readonly>
            </div>

            <div class="form-group">
              <p><label>Who will fix the issue?</label></p>
              <input type="text" class="form-control" value="${currentIssue.fixerOfTheIssue.firstName} ${currentIssue.fixerOfTheIssue.lastName}" readonly>
            </div>

            <div class="form-group">
              <p><label>Who will verify the issue is fixed?</label></p>
              <input type="text" class="form-control" value="${currentIssue.testerOfTheIssue.firstName} ${currentIssue.testerOfTheIssue.lastName}" readonly>
            </div>

            <div class="form-group">
              <p><label>Current status</label></p>
              <input type="text" class="form-control" value="${currentIssue.status}" readonly>
            </div>

            <div class="form-group">
              <p><label>Change the status of issue</label></p>
              <c:if test="${!empty listOfStatus}">
                <sf:select path="status" cssClass="selectpicker" items="${listOfStatus}">
                </sf:select>
              </c:if>
            </div>

            <div class="form-group">
              <button type="submit" class="btn btn-success btn-lg">Submit</button>
              </sf:form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="gridForm">
        <div class = "container">
          <div class="col-sm-6">
            <p><h1 align="center" style="color: #1a5322">Logs</h1></p>

            <c:forEach items="${listOfChanges}" var="change">
              <c:set var="dateOfChange" value="${change.dateOfChange}" />
              <p class="bg-warning">
                <fmt:formatDate type="both" value="${dateOfChange}" /><br>
                <b>${change.basicText}</b><br>
                <c:if test="${! empty change.description}">
                  ${change.description}
                </c:if>
              </p>
            </c:forEach>

          </div>
        </div>
      </div>
    </div>

  </div>
</div>

<script type="text/javascript">
  function checkDelete(id)
  {
    if(confirm("Are u sure?"))
    {
      window.location = "/issue/delete/" + id;
    }
  }
</script>
<script src="<c:url value="/resources/js/disableSubmit.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet"  property=""/>

</body>
</html>
