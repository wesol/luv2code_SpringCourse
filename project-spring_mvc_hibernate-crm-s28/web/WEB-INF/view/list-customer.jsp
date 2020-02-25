<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <br>

    <div id="container">
        <div id="content">
            <input type="button" value="Add Customer"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>

            <br><br>

            <table>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>email</th>
                </tr>
                <c:forEach var="temp" items="${customers}">
                    <tr>
                        <td>${temp.id}</td>
                        <td>${temp.firstName}</td>
                        <td>${temp.lastName}</td>
                        <td>${temp.email}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</body>
</html>