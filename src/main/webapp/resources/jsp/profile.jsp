<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faces</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/static/css/profile.css' />"/>
</head>
<body>
<div class="wrapper">
    <!-- Header -->
    <div class="header">
        <c:if test="${birthday ne null or hometown ne null or email ne null}">
            <img class="header-logo"
                 src="<c:url value="/resources/static/images/profile-logo.png"/>"
                 width="90" height="50"/>
        </c:if>
        <span class="page-name">The Faces</span>

        <div class="header-form">
            <c:if test="${logged}">
                <form:form method="POST" action="/method/homepage"
                           cssClass="header-button-left">
                    <input type="submit"
                           class="header-button"
                           value="My page"/>
                </form:form>

                <form:form method="POST" action="/method/logout"
                           cssClass="header-button-right">
                    <input type="submit"
                           class="header-button"
                           value="Logout"/>
                </form:form>
            </c:if>

            <c:if test="${not logged}">
                <form:form method="POST" action="/method/redirect/signin"
                           cssClass="header-button-right">
                    <input type="submit"
                           class="header-button"
                           value="Sign in"/>
                </form:form>
            </c:if>
        </div>
    </div>

    <!-- Page -->
    <div class="content">
        <!-- Main block -->
        <div class="main-block">
            <!-- Photo -->
            <div class="photo-block">
                <div class="photo">
                    <!-- Image -->
                    <c:if test="${photo ne null}">
                        <img src="<c:url value="${photo}"/>"/>
                    </c:if>
                </div>
                <c:if test="${self}">
                    <form:form method="POST" action="/method/redirect/settings"
                               cssClass="command-button">
                        <input type="submit" class="command-button-link"
                               value="Edit profile"/>
                    </form:form>
                </c:if>
                <c:if test="${not self}">
                    <div class="command-button">
                        <!-- Empty button -->
                    </div>
                </c:if>
            </div>

            <!-- Information -->
            <div class="information-block">
                <!-- Header -->
                <div class="information-header">
                    <!-- Fullname -->
                    <span class="information-unit-value">${full_name}</span>
                </div>

                <c:if test="${birthday ne null or hometown ne null or email ne null}">
                    <!-- Body -->
                    <div class="information-body">
                        <c:if test="${birthday ne null}">
                            <!-- Birthday -->
                            <div class="information-unit">
                                <div class="information-unit-label-wrapper">
                                    <span class="information-unit-label">Birthday:</span>
                                </div>
                                <div class="information-unit-value-wrapper">
                                    <span class="information-unit-label">${birthday}</span>
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${hometown ne null}">
                            <!-- Hometown -->
                            <div class="information-unit">
                                <div class="information-unit-label-wrapper">
                                    <span class="information-unit-label">Hometown:</span>
                                </div>
                                <div class="information-unit-value-wrapper">
                                    <span class="information-unit-label">${hometown}</span>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${email ne null}">
                            <!-- Email -->
                            <div class="information-unit">
                                <div class="information-unit-label-wrapper">
                                    <span class="information-unit-label">Email:</span>
                                </div>
                                <div class="information-unit-value-wrapper">
                                    <span class="information-unit-label">${email}</span>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </c:if>

                <c:if test="${birthday == null and hometown == null and email == null}">
                    <!-- Empty information block -->
                    <div class="information-body">
                        <img class="information-logo"
                             src="<c:url value="/resources/static/images/profile-logo.png"/>"
                             width="90%" height="80%"/>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
