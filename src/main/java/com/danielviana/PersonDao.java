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
        open();
        stmt = con.prepareStatement("INSERT INTO person (name, email) VALUES(?, ?)");
        stmt.setString(1, p.getNamePerson());
        stmt.setString(2, p.getEmailPerson());
        stmt.execute();

        logger.log(Level.INFO, "Pessoa inserida com sucesso: {0} ({1})", new Object[]{p.getNamePerson(), p.getEmailPerson()});

        stmt.close();
        close();
    }

    public void updatePerson(Person p) throws Exception {
        open();
        stmt = con.prepareStatement("UPDATE person SET name = ?, email = ? WHERE id = ?");
        stmt.setString(1, p.getNamePerson());
        stmt.setString(2, p.getEmailPerson());
        stmt.setInt(3, p.getIdPerson());
        stmt.execute();
        stmt.close();
        close();
    }

    public void deletePerson(Person p) throws Exception {
        open();
        stmt = con.prepareStatement("DELETE FROM person WHERE id = ?");
        stmt.setInt(1, p.getIdPerson());
        stmt.execute();
        stmt.close();
        close();
    }

    public Person getPersonById(int cod) throws Exception {
        open();
        stmt = con.prepareStatement("SELECT id, name, email FROM person WHERE id = ?");
        stmt.setInt(1, cod);
        rs = stmt.executeQuery();
        Person p = null;
        if (rs.next()) {
            p = new Person();
            p.setIdPerson(rs.getInt("id"));
            p.setNamePerson(rs.getString("name"));
            p.setEmailPerson(rs.getString("email"));
        } else {
            logger.log(Level.WARNING, "Pessoa não encontrada com código: {0}", cod);
        }
        close();
        return p;
    }

    public List<Person> getAllPersons() throws Exception {
        try {
            open();
            stmt = con.prepareStatement("SELECT id, name, email FROM person");
            rs = stmt.executeQuery();
            List<Person> listPersons = new ArrayList<>();
            while (rs.next()) {
                Person p = new Person();
                p.setIdPerson(rs.getInt("id"));
                p.setNamePerson(rs.getString("name"));
                p.setEmailPerson(rs.getString("email"));
                listPersons.add(p);
            }
            close();
            return listPersons;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar as pessoas: {0}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
