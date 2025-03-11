package com.danielviana;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

    private static final String PERSONS_URL = "persons";
    private static final String EDIT_PERSON_URL = "editPerson";
    private static final String DELETE_PERSON_URL = "deletePerson";
    private static final String INSERT_PERSON_URL = "insertPerson";
    private static final String UPDATE_PERSON_URL = "updatePerson";

    private PersonDao personDao;

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
                case "/" + PERSONS_URL -> listPersons(request, response);
                case "/" + EDIT_PERSON_URL -> showEditForm(request, response);
                case "/" + DELETE_PERSON_URL -> deletePerson(request, response);
                default -> listPersons(request, response);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a requisição.");
        }
    }

    private void listPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Person> persons = personDao.getAllPersons();
        request.setAttribute("persons", persons);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/persons.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Person person = personDao.getPersonById(id);

        if (person == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuário não encontrado.");
            return;
        }

        request.setAttribute("person", person);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPerson.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Person person = new Person();
        person.setIdPerson(id);
        personDao.deletePerson(person);
        response.sendRedirect("persons");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/" + INSERT_PERSON_URL -> insertPerson(request, response);
                case "/" + UPDATE_PERSON_URL -> updatePerson(request, response);
                default -> listPersons(request, response);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a requisição.");
        }
    }

    private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Person person = new Person(Integer.parseInt(request.getParameter("id")), name, surname, email, password, role);
        personDao.updatePerson(person);
        response.sendRedirect("persons");
    }

    private void insertPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Person newPerson = new Person(name, surname, email, password, role);
        personDao.insertPerson(newPerson);
        response.sendRedirect("persons");
    }
}
