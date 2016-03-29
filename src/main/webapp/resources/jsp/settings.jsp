<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faces</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/static/css/settings.css' />"/>
</head>
<body>
<div class="settings-frame">
    <form:form method="POST" action="/edit" cssClass="settings-form"
               modelAttribute="profile">
        <c:if test="${error ne null}">
            <div class="settings-error-message">
                <span class="error-message">${error}</span>
            </div>
        </c:if>
        <div class="settings-column settings-left-column">
            <!-- First name -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">First name:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="firstName"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>

            <!-- Last name -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">Last name:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="lastName"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>

            <!-- Email -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">Email:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="email"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>

            <!-- Photo -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">Photo:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="photo"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>
        </div>
        <div class="settings-column settings-right-column">
            <!-- Birthday -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">Birthday:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="birthday"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>

            <!-- Hometown -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">Hometown:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="hometown"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>

            <!-- Url name -->
            <div class="settings-unit">
                <div class="settings-unit-label-wrapper">
                    <span class="settings-unit-label">Nickname:</span>
                </div>
                <div class="settings-unit-field-wrapper">
                    <form:input path="urlName"
                                cssClass="settings-unit-field"
                                autocomplete="off"/>
                </div>
            </div>
        </div>
        <input type="submit" class="settings-button settings-button-save"
               value="Save"/>
    </form:form>
    <form:form method="POST" action="method/delete" cssClass="settings-form">
        <input type="submit" class="settings-button settings-button-delete"
               value="Delete account"/>
    </form:form>
</div>
</body>
</html>
