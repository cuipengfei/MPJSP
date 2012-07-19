<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<title>name page</title>
<p>please enter the name</p>

<form:form id="name" modelAttribute="personalInfo" action="${flowExecutionUrl}">
    <form:input path="name" />
    <p>
        <button class="button positive" type="submit" id="next" name="_eventId_next">Next</button>
        <button class="button" type="submit" name="_eventId_cancel">Cancel</button>
    </p>
</form:form>