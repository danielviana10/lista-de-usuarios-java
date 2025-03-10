<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
<head>
  <title>Lista de Pessoas</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <h1>Lista de Pessoas</h1>
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Editar</th>
            <th>Excluir</th>
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td>${person.idPerson}</td>
                <td>${person.namePerson}</td>
                <td>${person.emailPerson}</td>
                <td>
                  <a href="editPerson?id=${person.idPerson}">
                    <i class="fas fa-edit"></i>
                </a>
                </td>
                <td>
                  <a href="deletePerson?id=${person.idPerson}" 
                  onclick="return confirm('Tem certeza que deseja excluir esta pessoa?')">
                    <i class="fas fa-trash"></i>
                </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="insertPerson.jsp">Inserir Nova Pessoa</a>
</body>
</html>