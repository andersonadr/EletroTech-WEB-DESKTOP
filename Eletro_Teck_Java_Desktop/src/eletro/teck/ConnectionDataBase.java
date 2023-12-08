/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eletro.teck;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno_Manha
 */

public class ConnectionDataBase {
    // URL de conexão com o banco de dados MySQL
    private static final String URL_MYSQL = "jdbc:mysql://db4free.net:3306/eletrotech";
    // Driver JDBC do MySQL
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    // Nome de usuário do banco de dados
    private static final String USER = "adv12345";
    // Senha do banco de dados
    private static final String PASS = "adv12345";

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() {
        try {
            // Carregar o driver JDBC
            Class.forName(DRIVER_CLASS);
            // Estabelecer a conexão
            Connection conn = DriverManager.getConnection(URL_MYSQL, USER, PASS);
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            // Lidar com exceções, por exemplo, imprimir o rastreamento de pilha
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }
}
