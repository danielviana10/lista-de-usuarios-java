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
        String url = "jdbc:postgresql://localhost:5432/seuBancoDeDados";
        String user = "seuUsuario";
        String password = "suaSenha";

        try {
            con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                logger.log(Level.INFO, "Conexão com o banco de dados estabelecida com sucesso!");
                createTableIfNotExists();
            } else {
                logger.log(Level.SEVERE, "Falha ao estabelecer conexão com o banco de dados.");
            }
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

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS person ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(30) NOT NULL, "
                + "surname VARCHAR(50) NOT NULL, "
                + "email VARCHAR(40) NOT NULL, "
                + "password VARCHAR(100) NOT NULL, "
                + "role VARCHAR(20) NOT NULL);";

        try (PreparedStatement stmtStart = con.prepareStatement(sql)) {
            stmtStart.execute();
            logger.log(Level.INFO, "Tabela 'person' verificada/criada com sucesso.");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao criar a tabela 'person': {0}", ex.getMessage());
        }
    }
}
