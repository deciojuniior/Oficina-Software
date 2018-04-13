package br.com.oficinaSoftware.dao;

import br.com.oficinaSoftware.controller.LoginController;
import br.com.oficinaSoftware.entity.Fornecedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {

    private Connection conexaoUsuario() throws SQLException, ClassNotFoundException {
        String url ="jdbc:postgresql://localhost:5432/OI";
        String usuario="postgres";
        String senha = "postgres";

        Class.forName("org.postgresql.Driver");
        Connection conexao = DriverManager.getConnection(url,usuario,senha);

        return conexao;
    }

    public void salvarFornecedor(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection conexao = conexaoUsuario();
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Fornecedor(nome,telefone,endereco, _idusuario,cnpj,email)VALUES (?, ?, ?, ?, ?, ?)");
        String idUserF = LoginController.idValor;
        stmt.setString(1, fornecedor.getNomeFornecedor());
        stmt.setString(2, fornecedor.getTelefoneFornecedor());
        stmt.setString(3, fornecedor.getEnderecoFornecedor());
        stmt.setInt(4, Integer.valueOf(idUserF));
        stmt.setString(5, fornecedor.getCnpjFornecedor());
        stmt.setString(6, fornecedor.getEmailFornecedor());

        stmt.executeUpdate();
    }


}
