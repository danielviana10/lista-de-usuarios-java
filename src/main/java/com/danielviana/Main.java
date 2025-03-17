package com.danielviana;

import java.util.List;
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
            // Person per = pd.getPersonById(39);
            // per.setEmailPerson("daniel1@gmail.com");
            // if (pd.updatePerson(per)) {
            // logger.info("Pessoa alterada com sucesso!");
            // }
            // List<Person> getAllPersons = pd.getAllPersons();
            // for (Person p : getAllPersons) {
            // logger.info(String.format("ID: %d, Nome: %s, Email: %s", p.getIdPerson(),
            // p.getNamePerson(), p.getEmailPerson()));
            // }
            // Excluir pessoa
            // Person per = pd.getPersonById(40);
            // pd.deletePerson(per);
            // List<Person> getAllPersons = pd.getAllPersons();
            // for (Person p : getAllPersons) {
            // logger.log(Level.INFO, "ID: {0}, Nome: {1}, Email: {2}", new
            // Object[]{p.getIdPerson(), p.getNamePerson(), p.getEmailPerson()});
            // }
            // Obter pessoa por ID
            // Person p = pd.getPersonById(39);
            // logger.log(Level.INFO, "ID: {0}, Nome: {1}, Email: {2}", new
            // Object[]{p.getIdPerson(), p.getNamePerson(), p.getEmailPerson()});
            // Listar todas as pessoas
            List<Person> listOfPersons = pd.getAllPersons();
            logger.info("-------------------------------------------------");
            for (Person p : listOfPersons) {
                logger.info(String.format("ID: %d, Nome: %s, Email: %s", p.getIdPerson(),
                        p.getNamePerson(), p.getEmailPerson()));
                logger.info("-------------------------------------------------");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro no serviço main", e);
        }
    }
}
