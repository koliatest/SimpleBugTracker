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

  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>

<%@include file="../parts/header.jsp"%>

<div class="container body-content">
  <div class="row">

    <div class="col-md-6">
      <div class="formAdd">
        <div class = "container">
          <div class="col-sm-6">
            <h1 class="header">Information of the project</h1>
            <div style="margin-left: 395px;">
              <button type="button" class="btn btn-danger" onclick="checkDelete(${currentProject.id})">Delete project</button>
            </div>
            <sf:form id="myForm" cssClass="form-horizontal" method = "post" modelAttribute = "dto">

            <div class="form-group">
              <p><label>Project name</label></p>
              <input type="text" id="nameOfTheProject" name="nameOfTheProject" class="form-control" value="${currentProject.nameOfTheProject}">
            </div>

            <div class="form-group">
              <p><label>Lead of the project</label></p>
              <c:if test="${!empty listOfUsersInProject}">
                <sf:select id="selectForUsers" path="leadOfTheProject" cssClass="selectpicker">
                  <c:forEach items="${listOfUsersInProject}" var="user">
                    <option
                            <c:if test="${user.id eq currentProject.leadOfTheProject.id}">selected="selected"</c:if>
                            value="${user.id}">${user.firstName} ${user.lastName}
                    </option>
                  </c:forEach>
                </sf:select>
              </c:if>
              <c:if test="${empty listOfUsersInProject}">
                There are no users in current project
              </c:if>
            </div>

            <div class="form-group">
              <nobr><label>Description</label></nobr>
              <textarea style="height: 150px;" name="descriptionOfTheProject" class="form-control">${currentProject.descriptionOfTheProject}</textarea>
            </div>

            <div class="form-group">
              <nobr><label>Users in project</label></nobr>
              <table class="table table-striped">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>#</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${listOfUsersInProject}" var = "user">
                  <tr>
                    <td><a href="/user/inform/${user.id}">${user.firstName} ${user.lastName}</a></td>
                    <td><a href="/project/${currentProject.id}/delete/user/${user.id}"  class="btn btn-danger">Remove</a></td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>

            <div class="form-group">
              <nobr><label>Add user to the project</label></nobr>
              <textarea style="height: 150px;" class="form-control" id="usersInTheCurrentProject" name="usersInTheCurrentProject" placeholder="login1; login2; login3; login4;"></textarea>
            </div>

            <div class="form-group">
              <button type="submit" class="btn btn-success btn-lg">Submit changes</button>
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

            <div id="piechart" style="width: 900px; height: 500px;"></div>

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
      window.location = "/project/delete/" + id;
    }
  }

  var data = [
    ['Status of issue', 'Count'],
    ['Opened',     ${countOfOpened}],
    ['In progress', ${countOfInProgress}],
    ['Rejected',  ${countOfRejected}],
    ['Deferred', ${countOfDeferred}],
    ['Test',    ${countOfTest}],
    ['Verified', ${countOfVerified}],
    ['Reopened', ${countOfReopened}],
    ['Closed', ${countOfClosed}]
  ];

  function googleLoaded() {
    drawChart(data, 'Project statistic of issues', 'piechart');
  }
</script>
<script src="<c:url value="/resources/js/googleChart.js" />" > </script>
<script src="<c:url value="/resources/js/disableSubmit.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet"  property=""/>

</body>
</html>
