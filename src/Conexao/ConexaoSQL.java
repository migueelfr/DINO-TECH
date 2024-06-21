package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoSQL {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:C:\\Users\\MIguel\\IdeaProjects\\Loja.GUI\\src\\database\\loja1.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Conexão com SQLite estabelecida.");

        } catch (ClassNotFoundException | SQLException e) {

            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, "Erro ao conectar ao banco de dados", e);

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, "Erro ao fechar a conexão com o banco de dados", ex);
            }
        }
    }
}