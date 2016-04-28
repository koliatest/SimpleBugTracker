<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
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
      <ul class="nav navbar-nav navbar-right">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
          <li><a href="#">Admin page</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/issue/create">Create issue</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/project/create">Create project</a></li>
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
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">All projects</a></li>
    <li role="separator" class="divider"></li>
    <c:if test="${! empty listOfProjects}">
      <c:forEach items = "${listOfProjects}" var = "project">
        <li><a href="#">${project.nameOfTheProject}</a></li>
      </c:forEach>
    </c:if>
  </ul>
</div>

<c:if test = "${!empty listOfProjects}">
  <div class="container">
  <div class="formAdd">
  <table id="example" class="table" cellspacing="0" width="100%">
    <thead>
    <tr>
      <th>#</th>
      <th>Title</th>
      <th>Fixer</th>
      <th>Tester</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items = "${listOfProjects}" var = "project">
      <tr>
        <td><a href="#" class = "btn btn-success btn-lg">Open</a></td>
        <td><td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </div>
  </div>
</c:if>

<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet"  property=""/>


</body>
</html>
