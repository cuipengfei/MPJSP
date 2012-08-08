<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<title>result page</title>
<p>info collected</p>
<p><c:out value="${personalInfo.name}" /></p>
<p><c:out value="${personalInfo.hobby}"/></p>

<br/>
<br/>
<br/>

<p>This is all the personal info we collected</p>

<table>
      <c:forEach var="info" items="${allInfo}">
        <tr>
          <td>${info.name}</td>
          <td>${info.hobby}</td>
        </tr>
      </c:forEach>
    </table>
