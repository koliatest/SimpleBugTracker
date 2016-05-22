<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>

  <%@include file="parts/bootstrap-part.jsp"%>

  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>

<%@include file="parts/header.jsp"%>

<div class="container body-container">
  <div class="row">
    <div class="col-md-6">
      <div class="formAdd">
        <div class = "container">
          <div class="col-sm-6">
            <h1 class="header">User information</h1>
            <sf:form id="myForm" cssClass="form-horizontal">

            <div class="form-group">
              <nobr><label>Login</label></nobr>
              <input type="text" class="form-control" value="${userToLook.login}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>First name</label></nobr>
              <input type="text" class="form-control" value="${userToLook.firstName}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>Last name</label></nobr>
              <input type="text" class="form-control" value="${userToLook.lastName}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>Email</label></nobr>
              <input type="text" class="form-control" value="${userToLook.email}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>User's projects</label></nobr>
              <table class="table table-striped">
                <thead>
                <tr>
                  <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${listOfProjects}" var = "project">
                  <tr>
                    <td>${project.nameOfTheProject}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>

            <div class="form-group">
              <a href="/profile" class="btn btn-success">Go to profile</a>
              </sf:form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="gridFormChart">
        <div class = "container">
          <div class="col-sm-6">
            <div id="piechartToFix" style="width: 900px; height: 500px;"></div>
            <div id="piechartToTest" style="width: 900px; height: 500px;"></div>
          </div>
        </div>
      </div>
    </div>

  </div>
</div>

<script type="text/javascript">

  var dataToFix = [
    ['Status of issue', 'Count'],
    ['Opened',     ${countFixOfOpened}],
    ['In progress', ${countFixOfInProgress}],
    ['Rejected',  ${countFixOfRejected}],
    ['Deferred', ${countFixOfDeferred}],
    ['Test',    ${countFixOfTest}],
    ['Verified', ${countFixOfVerified}],
    ['Reopened', ${countFixOfReopened}],
    ['Closed', ${countFixOfClosed}]
  ];

  var dataToTest = [
    ['Status of issue', 'Count'],
    ['Opened',     ${countTestOfOpened}],
    ['In progress', ${countTestOfInProgress}],
    ['Rejected',  ${countTestOfRejected}],
    ['Deferred', ${countTestOfDeferred}],
    ['Test',    ${countTestOfTest}],
    ['Verified', ${countTestOfVerified}],
    ['Reopened', ${countTestOfReopened}],
    ['Closed', ${countTestOfClosed}]
  ];

  function googleLoaded() {
    drawChart(dataToFix, 'User statistic of issues to fix', 'piechartToFix');
    drawChart(dataToTest, 'User statistic of issues to test', 'piechartToTest');
  }

</script>

<script src="<c:url value="/resources/js/googleChart.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet"  property=""/>

</body>
</html>

