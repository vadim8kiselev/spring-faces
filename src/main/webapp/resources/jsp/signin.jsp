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
        <p>Sign in to Faces</p>
    </div>
    <c:if test="${error ne null}">
        <div class="auth-unit auth-error auth-error-message">
            <span>${error}</span>
        </div>
    </c:if>
    <div class="auth-body">
        <form:form method="POST" class="auth-input-fields"
                   action="/session" modelAttribute="profile">

            <div class="auth-label-wrapper">
                <p class="auth-label">Usernmame</p>
            </div>
            <form:input path="username" cssClass="auth-field auth-text"
                        autocomplete="off" required="required"/>

            <div class="auth-label-wrapper">
                <p class="auth-label">Password</p>
            </div>
            <form:password path="password" cssClass="auth-field auth-text"
                           autocomplete="off" required="required"/>

            <input type="submit" class="auth-field auth-button"
                   value="Sign in"/>
        </form:form>
    </div>
    <div class="auth-unit auth-footer">
        <span>New to Faces?</span>
        <a class="auth-link"
           href="<c:url value="/signup"/>">Create an account</a>
    </div>
</div>
</body>
</html>
