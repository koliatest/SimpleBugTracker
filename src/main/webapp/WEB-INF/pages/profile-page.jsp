<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

  <%@include file="parts/bootstrap-part.jsp"%>

</head>
<body onload="checkSelectedProject('${selectedProjectName}')">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Bugtracker</a>
    </div>

    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/user">${currentUser.firstName} ${currentUser.lastName}</a></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
          <li><a href="#">Admin page</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/project/create">Create project</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/issue/create">Create issue</a></li>
        </sec:authorize>
        <li><a href="/about">About</a></li>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/auth/logout">Logout</a></li>
        </sec:authorize>
      </ul>
    </div><!--/.navbar-collapse -->
  </div>
</nav>

<div class="dropdown" align="center" style="margin-top: 80px;">
  <button class="btn btn-default btn-lg dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    Issues: ${selectedProjectName}
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu dropdown-menu1" aria-labelledby="dropdownMenu1">
    <li><a href="/profile">All projects</a></li>
    <li role="separator" class="divider"></li>
    <c:if test="${! empty listOfProjects}">
      <c:forEach items = "${listOfProjects}" var = "project">
        <li><a href="/profile/project/${project.id}">${project.nameOfTheProject}</a></li>
      </c:forEach>
    </c:if>
  </ul>
</div>

<div id="manageProjectDiv" style="margin-left: 1200px">

</div>

<c:if test = "${!empty listOfIssues}">
  <div class="container">
  <div class="formAdd">
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Title</th>
      <th>Fixer</th>
      <th>Tester</th>
      <th>Priority</th>
      <th>#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items = "${listOfIssues}" var = "issue">
      <tr>
        <td>${issue.titleOfIssue}</td>
        <td>${issue.fixerOfTheIssue.firstName} ${issue.fixerOfTheIssue.lastName}</td>
        <td>${issue.testerOfTheIssue.firstName} ${issue.testerOfTheIssue.lastName}</td>
        <td>${issue.priority}</td>
        <td><a href="/issue/inform/${issue.id}"  class="btn btn-success custom">${issue.status}</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </div>
  </div>
</c:if>
<c:if test="${empty listOfIssues}">
  <h1 align="center">There are no issues</h1>
</c:if>

<%@include file="parts/footer.jsp"%>

<script type="text/javascript">
  function checkSelectedProject(name){
    if(name != "All Projects")
    {
      var myDiv = document.getElementById("manageProjectDiv");
      var aTag = document.createElement('a');
      aTag.setAttribute('href', "/project/inform/" + ${selectedProject.id});
      aTag.setAttribute('class', "btn btn-warning");
      aTag.innerHTML = "Manage project";
      myDiv.appendChild(aTag);
    }
  }
</script>

<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet"  property=""/>


</body>
</html>
