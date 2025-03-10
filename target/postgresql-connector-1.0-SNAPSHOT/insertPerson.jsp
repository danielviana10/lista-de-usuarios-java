<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
    <title>Inserir Pessoa</title>
</head>
<body>
    <h1>Inserir Nova Pessoa</h1>
    <form action="insertPerson" method="post">
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <button type="submit">Salvar</button>
    </form>

    <br>
    <a href="persons.jsp">Voltar para a lista de pessoas</a>
</body>
</html>