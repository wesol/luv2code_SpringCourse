<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>List Customer</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>email</th>
        </tr>
        <c:forEach var="temp" items="${customers}">
            <tr>
                <th>${temp.id}</th>
                <th>${temp.firstName}</th>
                <th>${temp.lastName}</th>
                <th>${temp.email}</th>
            </tr>
        </c:forEach>
    </table>

</body>
</html>