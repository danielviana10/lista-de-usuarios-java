package com.danielviana;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDao extends Dao {

    private static final Logger logger = Logger.getLogger(PersonDao.class.getName());

    public void insertPerson(Person p) throws Exception {
        try {
            open();

            stmt = con.prepareStatement(
                    "INSERT INTO person (name, email) VALUES(?, ?)");
            stmt.setString(1, p.getNamePerson());
            stmt.setString(2, p.getEmailPerson());
            stmt.execute();

            logger.log(Level.INFO, "Pessoa inserida com sucesso: {0} ({1})",
                    new Object[] { p.getNamePerson(), p.getEmailPerson() });
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao inserir pessoa: {0}", e.getMessage());
            throw new Exception("Erro ao inserir pessoa", e);
        } finally {
            close();
        }
    }

    public boolean updatePerson(Person p) throws Exception {
        try {
            open();

            stmt = con.prepareStatement(
                    "UPDATE person SET name = ?, email = ? WHERE id = ?");
            stmt.setString(1, p.getNamePerson());
            stmt.setString(2, p.getEmailPerson());
            stmt.setInt(3, p.getIdPerson());
            stmt.execute();
            logger.info("Pessoa atualizada com sucesso.");
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao atualizar pessoa: {0}", ex.getMessage());
            throw new Exception("Erro ao atualizar pessoa", ex);
        } finally {
            close();
        }
    }

    public void deletePerson(Person p) throws Exception {
        try {
            open();
            stmt = con.prepareStatement("DELETE FROM person WHERE id = ?");
            stmt.setInt(1, p.getIdPerson());
            stmt.execute();
            logger.info("Pessoa excluída com sucesso.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao excluir pessoa: {0}", e.getMessage());
            throw new Exception("Erro ao excluir pessoa", e);
        } finally {
            close();
        }
    }

    public Person getPersonById(int cod) throws Exception {
        Person p = null;
        try {
            open();
            stmt = con.prepareStatement("SELECT id, name, surname, email, password, role FROM person WHERE id = ?");
            stmt.setInt(1, cod);
            rs = stmt.executeQuery();
            if (rs.next()) {
                p = new Person();
                p.setIdPerson(rs.getInt("id"));
                p.setNamePerson(rs.getString("name"));
                p.setEmailPerson(rs.getString("email"));
            } else {
                logger.log(Level.WARNING, "Pessoa não encontrada com código: {0}", cod);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar pessoa por ID: {0}", e.getMessage());
            throw new Exception("Erro ao buscar pessoa por ID", e);
        } finally {
            close();
        }
        return p;
    }

    public List<Person> getAllPersons() throws Exception {
        List<Person> listPersons = new ArrayList<>();
        try {
            open();
            stmt = con.prepareStatement("SELECT id, name, email FROM person ORDER BY id");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setIdPerson(rs.getInt("id"));
                p.setNamePerson(rs.getString("name"));
                p.setEmailPerson(rs.getString("email"));
                listPersons.add(p);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar as pessoas: {0}", e.getMessage());
            throw new Exception("Erro ao listar as pessoas", e);
        } finally {
            close();
        }

        if (listPersons.isEmpty()) {
            return Collections.emptyList();
        }

        return listPersons;
    }
}
