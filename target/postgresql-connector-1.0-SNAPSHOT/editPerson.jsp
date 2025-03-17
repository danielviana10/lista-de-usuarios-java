<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
    <title>Editar Pessoa</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h1 class="my-4">Editar Pessoa</h1>
        <form action="updatePerson" method="post">
            <input type="hidden" name="id" value="${person.idPerson}">
            <div class="mb-3">
                <label for="name" class="form-label">Nome:</label>
                <input type="text" id="name" name="name" value="${person.namePerson}" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" id="email" name="email" value="${person.emailPerson}" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>