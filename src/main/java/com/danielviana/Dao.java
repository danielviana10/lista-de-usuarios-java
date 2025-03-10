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
        String password = "Natura@10";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                logger.log(Level.INFO, "Conexão com o banco de dados estabelecida com sucesso!");
            } else {
                logger.log(Level.SEVERE, "Falha ao estabelecer conexão com o banco de dados.");
            }
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Driver do PostgreSQL não encontrado: {0}", ex.getMessage());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao conectar ao banco de dados: {0}", ex.getMessage());
        }
    }

    public void close() {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
            logger.log(Level.INFO, "Conexão e recursos fechados com sucesso.");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao fechar a conexão ou recursos: {0}", ex.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        if (con == null) {
            throw new SQLException("Conexão não está aberta. Chame o método open() primeiro.");
        }
        return con.prepareStatement(sql);
    }
}