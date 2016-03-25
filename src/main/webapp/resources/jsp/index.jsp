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
        <p>Sign up to Faces</p>
    </div>
    <div class="auth-body">
        <form:form method="POST" class="auth-input-fields"
                   action="method/signup" modelAttribute="profile">

            <div class="auth-label-wrapper">
                <p class="auth-label">Usernmame</p>
            </div>
            <form:input path="username" cssClass="auth-field auth-text"
                        autocomplete="off" required="required"/>

            <div class="auth-label-wrapper">
                <p class="auth-label">Password</p>
            </div>
            <form:hidden path="password" cssClass="auth-field auth-text"
                        autocomplete="off" required="required"/>

            <input type="submit" class="auth-field auth-button"
                   value="Sign up"/>
        </form:form>
    </div>
    <div class="auth-unit auth-footer">
        <span>Have an account on Faces?</span>
        <a class="auth-link" href="<c:url value="/signin"/>">Log in</a>
    </div>
</div>
</body>
</html>
