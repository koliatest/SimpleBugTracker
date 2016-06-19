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
            <sf:form id="myForm" cssClass="form-horizontal" method = "post">

            <div class="form-group">
              <p><label>Project name</label></p>
              <input type="text" class="form-control" value="${currentProject.nameOfTheProject}" readonly>
            </div>

            <div class="form-group">
              <p><label>Lead of the project</label></p>
              <input type="text" class="form-control" value="${currentProject.leadOfTheProject.firstName} ${currentProject.leadOfTheProject.lastName}" readonly>
            </div>

            <div class="form-group">
              <nobr><label>Description</label></nobr>
              <textarea style="height: 150px;" class="form-control" readonly>${currentProject.descriptionOfTheProject}</textarea>
            </div>

            <div class="form-group">
              <nobr><label>Users in project</label></nobr>
              <table class="table table-striped">
                <thead>
                <tr>
                  <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${listOfUsersInProject}" var = "user">
                  <tr>
                    <td><a href="/user/inform/${user.id}">${user.firstName} ${user.lastName}</a></td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>

            <div class="form-group">
              <a href="/profile" class="btn btn-success btn-lg">Back to profile</a>
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
<script src="<c:url value="/resources/js/gstatic.js" />" > </script>
<script src="<c:url value="/resources/js/googleChart.js" />" > </script>
<script src="<c:url value="/resources/js/disableSubmit.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/grid.css" />" rel="stylesheet"  property=""/>

</body>
</html>
