package br.com.fiap.fintech2.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    protected static Connection conn = null;

    public Connection getConnection() {
        return abrirBanco();
    }

    public static Connection abrirBanco() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm552504", "100997");

                // Desativa auto-commit
                conn.setAutoCommit(false);
            }
        } catch (Exception e) {
            System.out.println("Erro ao abrir conexao com o banco:  console->" + e.getMessage());
        }
        return conn;
    }

    public static void fecharBanco() {
        try {
            if (conn != null && !conn.isClosed()) {
                // Commit alterações antes de fechar 
                conn.commit();
                conn.close();
            }
        } catch (SQLException e) {
            // lida com exception
            System.out.println("Erro ao encerrar conexao com o banco:  console->   " + e.getMessage());
        }
    }
}
