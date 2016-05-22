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
            <h1 class="header">Edit the user</h1>
            <sf:form id="myForm" cssClass="form-horizontal" method = "post" modelAttribute = "user">

            <div class="form-group">
              <nobr><h2>Your login is <font color="#8a2be2" face="Times New Roman">${currentUser.login}</font></h2></nobr>
            </div>

            <div class="form-group">
              <nobr><label for="firstName">First name</label></nobr>
              <input type="text" class="form-control" id="firstName" name="firstName" value="${currentUser.firstName}">
            </div>

            <div class="form-group">
              <nobr><label for="lastName">Last name</label></nobr>
              <input type="text" class="form-control" id="lastName" name="lastName" value="${currentUser.lastName}">
            </div>

            <div class="form-group">
              <nobr><label for="email">Email</label></nobr>
              <input type="text" class="form-control" id="email" name="email" value="${currentUser.email}">
            </div>

            <div class="form-group">
              <button type="submit" class="btn btn-success btn-lg">Save & update user</button>
              <a href="/profile" class="btn btn-default">Cancel & return to profile</a>
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
<script src="<c:url value="/resources/js/disableSubmit.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet"  property=""/>

</body>
</html>

