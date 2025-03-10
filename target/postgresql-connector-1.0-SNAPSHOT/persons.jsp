<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
<head>
    <title>Lista de Pessoas</title>
</head>
<body>
    <h1>Lista de Pessoas</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td>${person.idPerson}</td>
                <td>${person.namePerson}</td>
                <td>${person.emailPerson}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>