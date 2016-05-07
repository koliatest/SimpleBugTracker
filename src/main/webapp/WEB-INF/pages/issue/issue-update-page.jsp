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
      <h1 class="header">Edit the issue</h1>
      <sf:form id="myForm" cssClass="form-horizontal" method = "post" modelAttribute = "dto">

      <div class="form-group">
        <p><label>Project</label></p>
        <c:if test="${!empty userProjects}">
          <sf:select id="selectForProject" path="projectId" cssClass="selectpicker">
            <c:forEach items="${userProjects}" var="project">
              <option
                      <c:if test="${project.id eq currentIssue.projectOfTheIssue.id}">selected="selected"</c:if>
                      value="${project.id}">${project.nameOfTheProject}
              </option>
            </c:forEach>
          </sf:select>
        </c:if>
        <c:if test="${empty userProjects}">
          There are no projects
        </c:if>
      </div>

      <div class="form-group">
        <nobr><label for="title">Title for issue</label></nobr>
        <input type="text" class="form-control" id="title" name="title" value="${currentIssue.titleOfIssue}">
      </div>

      <div class="form-group">
        <nobr><label>Description</label></nobr>
        <textarea style="height: 150px;" class="form-control" id="description" name="description">
          ${currentIssue.description}
        </textarea>
      </div>

      <div class="form-group">
        <p><label>Priority</label></p>
        <c:if test="${!empty listOfPriority}">
          <sf:select path="priority" cssClass="selectpicker">
            <c:forEach items="${listOfPriority}" var="prior">
              <option
                      <c:if test="${prior eq currentIssue.priority}">selected="selected"</c:if>
                      value="${prior}">${prior}
              </option>
            </c:forEach>
          </sf:select>
        </c:if>
      </div>

      <div class="form-group">
        <p><label>Who will fix the issue?</label></p>
        <c:if test="${!empty listOfUsers}">
          <sf:select id="selectForUsers" path="fixerId" cssClass="selectpicker">
            <c:forEach items="${listOfUsers}" var="user">
              <option
                      <c:if test="${user.id eq currentIssue.fixerOfTheIssue.id}">selected="selected"</c:if>
                      value="${user.id}">${user.firstName} ${user.lastName}
              </option>
            </c:forEach>
          </sf:select>
        </c:if>
        <c:if test="${empty listOfUsers}">
          There are no users
        </c:if>
      </div>

      <div class="form-group">
        <p><label>Who will verify the issue is fixed?</label></p>
        <c:if test="${!empty listOfUsers}">
          <sf:select path="testerId" cssClass="selectpicker">
            <c:forEach items="${listOfUsers}" var="user">
              <option
                      <c:if test="${user.id eq currentIssue.testerOfTheIssue.id}">selected="selected"</c:if>
                      value="${user.id}">${user.firstName} ${user.lastName}
              </option>
            </c:forEach>
          </sf:select>
        </c:if>
        <c:if test="${empty listOfUsers}">
          There are no users
        </c:if>
      </div>

      <div class="form-group">
        <button type="submit" class="btn btn-success btn-lg">Save & update issue</button>
        <a href="/issue/inform/${currentIssue.id}" class="btn btn-default">Cancel & return to issue</a>
        </sf:form>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  $('#myForm').one('submit', function() {
    $(this).find('button[type="submit"]').attr('disabled','disabled');
  });

  // get all measurement and replace elemId with it
  /*function getData(elemId, url) {
   $.get(url, function (data) {
   $(elemId).replaceWith(data);
   });
   }
   function selectProject(selectId, replaceId, url) {
   $(selectId).change(function () {
   getData(replaceId, url);
   });
   }
   $(document).ready(function () {
   // bind handlers
   selectProject("#selectForProject", "#selectForUsers", "/issue/create/project/" + $("#selectForProject").val());
   });*/
</script>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet"  property=""/>

</body>
</html>