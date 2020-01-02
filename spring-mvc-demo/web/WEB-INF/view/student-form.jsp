<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>
    <title>Student registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">
        <form:options items="${countryOptions.values()}"/>
    </form:select>
    <br><br>
    Favourite Language:
    <c:forEach var="temp" items="${programmingLanguages}">
       ${temp} <form:checkbox path="favoriteLanguage" value="${temp}"/>
    </c:forEach>
    <br><br>
    Operating systems:
    <c:forEach var="temp" items="${operatingSystems}">
        ${temp} <form:checkbox path="operatingSystems" value="${temp}"/>
    </c:forEach>
    <br><br>
    <input type="submit"/>
</form:form>
</body>
</html>
