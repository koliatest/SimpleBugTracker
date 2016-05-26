<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<title>Jumbotron Template for Bootstrap</title>

  <%@include file="parts/bootstrap-part.jsp"%>

</head>

<body>

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

      <ul class="nav navbar-nav navbar-right">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
          <li><a href="#">Admin page</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/profile">Profile</a></li>
        </sec:authorize>
        <li><a href="/about">About</a></li>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/auth/logout">Logout</a></li>
        </sec:authorize>
      </ul>

    </div><!--/.navbar-collapse -->
  </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
  <div class="container">
    <h1>Bugtracker</h1>
    <p>This is the simple, effective  bugtracker.</p>
    <p>For planning, coding and testing your projects.</p>
    <p>Get start by Sign In or Registration.</p>
    <a class="btn btn-success btn-lg" href="/login" role="button">Sign in &raquo;</a>
    <a class="btn btn-primary btn-lg" href="/registration" role="button">Registration &raquo;</a>
  </div>
</div>

<%@include file="parts/footer.jsp"%>

</body>
</html>
