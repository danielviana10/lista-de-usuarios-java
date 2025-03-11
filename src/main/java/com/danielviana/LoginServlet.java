package com.danielviana;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private PersonDao personDao;

    @Override
    public void init() {
        personDao = new PersonDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            boolean valid = personDao.authenticate(email, password);

            if (valid) {
                String token = generateToken(email);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"token\": \"" + token + "\"}");
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais inválidas");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a requisição");
        }
    }

    private String generateToken(String email) {
        return "generated_token_for_" + email;
    }
}