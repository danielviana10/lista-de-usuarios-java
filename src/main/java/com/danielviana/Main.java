package com.danielviana;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PersonDao pd = new PersonDao();

        try {
            // Incluir pessoa
            // Person p1 = new Person(1, "Daniel", "daniel@gmail.com");
            // Person p2 = new Person(2, "Matheus", "matheus@gmail.com");
            // Person p3 = new Person(3, "Miguel", "miguel@gmail.com");
            // Person p4 = new Person("Denir", "denir@gmail.com");
            Person p5 = new Person("Mislene", "mislene@gmail.com");
            // pd.insertPerson(p1);
            // pd.insertPerson(p2);
            // pd.insertPerson(p3);
            // pd.insertPerson(p4);
            pd.insertPerson(p5);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro no serviço main", e);
        }
    }
}
