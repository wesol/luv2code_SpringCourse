<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <form:option value="Brazil" label="Brazil"/>
        <form:option value="Poland" label="Poland"/>
        <form:option value="USA" label="USA"/>
        <form:option value="India" label="India"/>
    </form:select>

    <br><br>
    <input type="submit"/>

</form:form>
</body>
</html>
