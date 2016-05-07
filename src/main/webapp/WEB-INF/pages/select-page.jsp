<html>
<body>
<div class="form-group">
  <p><label>Who will fix the issue?</label></p>
  <c:if test="${!empty listOfUsers}">
    <sf:select id="selectForUsers" path="fixerId" cssClass="selectpicker">
      <c:forEach items="${listOfUsers}" var="user">
        <sf:option value="${user.id}">${user.firstName} ${user.lastName}</sf:option>
      </c:forEach>
    </sf:select>
  </c:if>
  <c:if test="${empty listOfUsers}">
    There are no users
  </c:if>
</div>
</body>
</html>