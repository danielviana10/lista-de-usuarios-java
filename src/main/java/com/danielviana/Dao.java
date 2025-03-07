package com.danielviana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

    private static final Logger logger = Logger.getLogger(Dao.class.getName());

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public void open() {
        String url = "jdbc:postgresql://localhost:5432/registrations";
        String user = "postgres";
        String password = "suaSenha";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao conectar ao banco de dados: {0}", ex.getMessage());
        }
    }

    public void close() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao fechar a conexão: {0}", ex.getMessage());
        }
    }

}
