package com.danielviana;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

    private PersonDao personDao;

    private static final Logger logger = Logger.getLogger(PersonServlet.class.getName());

    @Override
    public void init() {
        personDao = new PersonDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/persons" -> listPersons(request, response);
                case "/editPerson" -> showEditForm(request, response);
                case "/deletePerson" -> deletePerson(request, response);
                default -> listPersons(request, response);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a requisição.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/insertPerson" -> insertPerson(request, response);
                case "/updatePerson" -> updatePerson(request, response);
                default -> listPersons(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a requisição.");
        }
    }

    private void listPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Person> persons = personDao.getAllPersons();
        request.setAttribute("persons", persons);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/persons.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Person person = new Person(name, email);
        personDao.insertPerson(person);
        response.sendRedirect("persons");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Person person = personDao.getPersonById(id);
        request.setAttribute("person", person);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPerson.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                throw new Exception("ID não fornecido.");
            }

            int id = Integer.parseInt(idParam);
            Person person = new Person();
            person.setIdPerson(id);
            personDao.deletePerson(person);
            logger.info("Pessoa excluída com sucesso. ID: " + id);
            response.sendRedirect("persons");
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Erro ao converter ID: " + request.getParameter("id"), e);
            throw new Exception("ID inválido: " + request.getParameter("id"), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao excluir pessoa", e);
            throw new Exception("Erro ao excluir pessoa", e);
        }
    }

    private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Person person = new Person(id, name, email);
        personDao.updatePerson(person);
        response.sendRedirect("persons");
    }
}