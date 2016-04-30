<%@ page import="com.sprsec.model.Project" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.sprsec.service.ProjectService" %>
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

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>

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
            <h1 class="header">Create a new issue</h1>
            <sf:form id="myForm" cssClass="form-horizontal" method = "post" action="/issue/create" modelAttribute = "dto">

            <div class="form-group">
                <p><label>Project</label></p>
                <c:if test="${!empty userProjects}">
                    <sf:select path="projectId" cssClass="selectpicker">
                        <c:forEach items="${userProjects}" var="project">
                            <sf:option value="${project.id}">${project.nameOfTheProject}</sf:option>
                        </c:forEach>
                    </sf:select>
                </c:if>
                <c:if test="${empty userProjects}">
                    There are no projects
                </c:if>
            </div>

            <div class="form-group">
                <nobr><label for="title">Title for issue</label></nobr>
                <input type="text" class="form-control" id="title" name="title" placeholder="Title for issue">
            </div>

            <div class="form-group">
                <nobr><label>Description</label></nobr>
                <textarea style="height: 150px;" class="form-control" id="description" name="description" placeholder="Description"></textarea>
            </div>

            <div class="form-group">
                <p><label>Priority</label></p>
                <c:if test="${!empty listOfPriority}">
                    <sf:select path="priority" cssClass="selectpicker" items="${listOfPriority}">
                    </sf:select>
                </c:if>
            </div>

            <div class="form-group">
                <p><label>Who will fix the issue?</label></p>
                <c:if test="${!empty listOfUsers}">
                    <sf:select path="fixerId" cssClass="selectpicker">
                        <c:forEach items="${listOfUsers}" var="user">
                            <sf:option value="${user.id}">${user.firstName} ${user.lastName}</sf:option>
                        </c:forEach>
                    </sf:select>
                </c:if>
                <c:if test="${empty listOfUsers}">
                    There are no users
                </c:if>
            </div>

            <div class="form-group">
                <p><label>Who will verify the issue os fixed?</label></p>
                <c:if test="${!empty listOfUsers}">
                    <sf:select path="testerId" cssClass="selectpicker">
                        <c:forEach items="${listOfUsers}" var="user">
                            <sf:option value="${user.id}">${user.firstName} ${user.lastName}</sf:option>
                        </c:forEach>
                    </sf:select>
                </c:if>
                <c:if test="${empty listOfUsers}">
                    There are no users
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
</script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>

</body>
</html>
