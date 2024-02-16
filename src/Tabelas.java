import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Tabelas {
    public static DefaultTableModel consultarProdutos(String Nome) {
        String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false";
        String usuarioBanco = "root";
        String senhaBanco = "Google.com123";

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("Status");

        try (Connection connection = DriverManager.getConnection(url, usuarioBanco, senhaBanco)) {
            String sql = "SELECT * FROM produtos";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    model.addRow(new Object[]{
                            resultSet.getString("ID"),
                            resultSet.getString("Nome"),
                            resultSet.getString("Valor"),
                            resultSet.getString("Status")
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
}

