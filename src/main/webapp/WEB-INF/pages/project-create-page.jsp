<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <li><a href="/about">About</a></li>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/auth/logout">Logout</a></li>
        </sec:authorize>
      </ul>
    </div><!--/.navbar-collapse -->
  </div>
</nav>

<div class="formAdd">
<div class = "container">
  <div class="col-sm-6">
    <h1 class="header">Create project</h1>
    <sf:form cssClass="form-horizontal" method = "post" action="/project/create" modelAttribute = "project">
      <div class="form-group">
        <nobr><label for="nameOfTheProject">Name of the project</label></nobr>
          <input type="text" class="form-control" id="nameOfTheProject" name="nameOfTheProject" placeholder="Name of the project">
      </div>
      <div class="form-group">
        <nobr><label for="descriptionOfTheProject">Description of the project</label></nobr>
          <textarea style="height: 170px;" class="form-control" id="descriptionOfTheProject" name="descriptionOfTheProject" placeholder="Description of the project"></textarea>
      </div>
      <div class="form-group">
          <button type="submit" class="btn btn-success">Submit</button>
    </sf:form>
  </div>
</div>
</div>
</div>
<script src="<c:url value="/resources/js/registration.js" />" > </script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>

</body>
</html>