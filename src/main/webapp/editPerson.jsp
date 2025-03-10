<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
    <title>Editar Pessoa</title>
</head>
<body>
    <h1>Editar Pessoa</h1>
    <form action="updatePerson" method="post">
        <input type="hidden" name="id" value="${person.idPerson}">
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" value="${person.namePerson}" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${person.emailPerson}" required><br><br>
        <button type="submit">Salvar</button>
    </form>
    <br>
    <a href="persons">Voltar para a lista de pessoas</a>
</body>
</html>