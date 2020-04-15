<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Custom login page</title>

    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

    <h3>My custom login form</h3>

    <form:form id="form" action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

        <!--Check for login error-->
        <c:if test="${param.error != null}">
            <i class="failed">Invalid name or password.</i>
        </c:if>

        <p>
            User name: <input type="text" name="username"/>
        </p>

        <p>
            Password: <input type="password" name="password"/>
        </p>

        <input type="submit" value="Login">

    </form:form>

</body>
</html>
