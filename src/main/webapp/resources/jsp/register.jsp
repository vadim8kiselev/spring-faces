<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faces</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/static/css/main.css' />"/>
</head>
<body>
<div class="auth-form">
    <div class="auth-header">
        <p>Complete registration</p>
    </div>
    <div class="auth-body">
        <form:form method="POST" class="auth-input-fields"
                   action="/method/register" modelAttribute="profile">

            <div class="auth-label-wrapper">
                <p class="auth-label">First name</p>
            </div>
            <form:input path="firstName" cssClass="auth-field auth-text"
                        autocomplete="off" required="required"/>

            <div class="auth-label-wrapper">
                <p class="auth-label">Last name</p>
            </div>
            <form:input path="lastName" cssClass="auth-field auth-text"
                        autocomplete="off" required="required"/>

            <div class="auth-label-wrapper">
                <p class="auth-label">Link to photo (optionally)</p>
            </div>
            <form:input path="photo" cssClass="auth-field auth-text"
                        autocomplete="off"/>

            <input type="submit" class="auth-field auth-button"
                   value="Complete registration"/>
        </form:form>
    </div>
</div>
</body>
</html>
