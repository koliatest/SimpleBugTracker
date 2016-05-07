

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

