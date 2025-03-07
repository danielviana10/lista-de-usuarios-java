package com.danielviana;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PersonDao pd = new PersonDao();

        try {
            // Incluir pessoa
            // Person p1 = new Person("Daniel", "daniel@gmail.com");
            // Person p2 = new Person("Matheus", "matheus@gmail.com");
            // Person p3 = new Person("Miguel", "miguel@gmail.com");
            // Person p4 = new Person("Denir", "denir@gmail.com");
            // Person p5 = new Person("Mislene", "mislene@gmail.com");
            // pd.insertPerson(p1);
            // pd.insertPerson(p2);
            // pd.insertPerson(p3);
            // pd.insertPerson(p4);
            // pd.insertPerson(p5);

            // Alterar pessoa
            // Person per = pd.getPersonById(3);
            // if (per != null) {
            //     per.setEmailPerson("mislene1@gmail.com");
            //     pd.updatePerson(per);
            //     List<Person> getAllPersons = pd.getAllPersons();
            //     for (Person p : getAllPersons) {
            //         logger.log(Level.INFO, "ID: {0}, Nome: {1}, Email: {2}", new Object[]{p.getIdPerson(), p.getNamePerson(), p.getEmailPerson()});
            //     }
            // }
            // Excluir pessoa
            // Person per = pd.getPersonById(2);
            // pd.deletePerson(per);
            // List<Person> getAllPersons = pd.getAllPersons();
            // for (Person p : getAllPersons) {
            //     logger.log(Level.INFO, "ID: {0}, Nome: {1}, Email: {2}", new Object[]{p.getIdPerson(), p.getNamePerson(), p.getEmailPerson()});
            // }
            // Obter pessoa por ID
            Person p = pd.getPersonById(4);
            logger.log(Level.INFO, "ID: {0}, Nome: {1}, Email: {2}", new Object[]{p.getIdPerson(), p.getNamePerson(), p.getEmailPerson()});
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro no serviço main", e);
        }
    }
}
