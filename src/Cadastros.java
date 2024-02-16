import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastros {
    public void cadastrarProdutos(String nome, String valor) {
        String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false";
        String usuarioBanco = "root";
        String senhaBanco = "Google.com123";

        try (Connection connection = DriverManager.getConnection(url, usuarioBanco, senhaBanco)) {
            String query = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, valor);
                preparedStatement.executeUpdate();
                System.out.println("Produto cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao cadastrar Produto.");
        }
    }
}
