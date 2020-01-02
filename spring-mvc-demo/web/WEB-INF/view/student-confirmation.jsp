<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>
<p>The student is confirmed: ${student.lastName} ${student.firstName} from ${student.country}</p>

<p>Favorite programming language is: ${student.favoriteLanguage}</p>

<p>Operating systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li> ${temp} </li>
    </c:forEach>
</ul>
</p>

</body>
</html>
