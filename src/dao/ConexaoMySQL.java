package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/pinguin_empresa?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";

    public static Connection conectar() throws SQLException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {

            throw new SQLException("Driver JDBC não encontrado!", e);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados!", e);
        }
    }
}