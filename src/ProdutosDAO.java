/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    

    private String url = "jdbc:mysql://localhost:3306/uc11?useSSL=false";
    private String usuarioBanco = "root";
    private String senhaBanco = "Google.com123";

    public void venderProduto(String id) {
        String query = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, usuarioBanco, senhaBanco);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Produto vendido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao vender o produto.");
        }
    }
    
    public void listarProdutosVendidos() {
        
    }
    
    
    
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

