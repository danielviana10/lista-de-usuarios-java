<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
<head>
    <title>Lista de Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h2 class="my-4">Lista de Usuários</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="person" items="${persons}">
                    <tr>
                        <td>${person.idPerson}</td>
                        <td>${person.namePerson}</td>
                        <td>${person.emailPerson}</td>
                        <td>
                            <a href="#" 
                                class="btn btn-warning btn-sm edit-button" 
                                data-bs-toggle="modal" 
                                data-bs-target="#editPersonModal" 
                                data-id="${person.idPerson}" 
                                data-name="${person.namePerson}" 
                                data-email="${person.emailPerson}">
                                  <i class="bi bi-pencil"></i>
                            </a>
                        </td>
                        <td>
                            <a href="#" 
                                class="btn btn-danger btn-sm delete-button" 
                                data-bs-toggle="modal" 
                                data-bs-target="#confirmDeleteModal" 
                                data-id="${person.idPerson}">
                                  <i class="bi bi-trash"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="includes/deleteModal.jsp" />
    <jsp:include page="includes/editModal.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

    <jsp:include page="includes/scripts.jsp" />
</body>
</html>