<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Home page</h2>

    <hr>

    <!-- display username and role -->
    User: <security:authentication property="principal.username"/>
    Role(s): <security:authentication property="principal.authorities"/>

    <hr>

    Welcome!

    <hr>

    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leaders Meeting</a>
        </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">Admins Meeting</a>
        </p>
    </security:authorize>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="logout">
    </form:form>

</body>
</html>
