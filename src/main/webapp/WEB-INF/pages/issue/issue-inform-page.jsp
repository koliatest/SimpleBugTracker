<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>

  <%@include file="../parts/bootstrap-part.jsp"%>

</head>
<body>

<%@include file="../parts/header.jsp"%>

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

<script type="text/javascript">
  $('#myForm').one('submit', function() {
    $(this).find('button[type="submit"]').attr('disabled','disabled');
  });

  function checkDelete(id)
  {
    if(confirm("Are u sure?"))
    {
      window.location = "/issue/delete/" + id;
    }
  }
</script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>

</body>
</html>
