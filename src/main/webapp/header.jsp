<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" rel="stylesheet">
    <title>Sistema de Gerenciamento de Usuários</title>
</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="bg-primary text-white p-3 mb-4">
    <div class="container">
        <div class="d-flex justify-content-between align-items-center">
            <span class="h4">Sistema de Gerenciamento de Usuários</span>
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle fs-5" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                    Usuários
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item" href="persons">Ver Todos</a></li>
                    <li><a class="dropdown-item" href="insertPerson.jsp">Novo Usuário</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>