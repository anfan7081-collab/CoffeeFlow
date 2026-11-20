package br.com.coffeeflow.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexao {
    private static final String URL = System.getenv().getOrDefault(
        "COFFEEFLOW_DB_URL", "jdbc:mysql://localhost:3306/CoffeeFlow?serverTimezone=UTC");
    private static final String USUARIO = System.getenv().getOrDefault("COFFEEFLOW_DB_USER", "root");
    private static final String SENHA = System.getenv().getOrDefault("COFFEEFLOW_DB_PASSWORD", "");

    private Conexao() {}

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
