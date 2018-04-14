package br.com.oficinaSoftware.dao;

import br.com.oficinaSoftware.controller.LoginController;
import br.com.oficinaSoftware.entity.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {

	DAO dao = new DAO();

    public void salvarFornecedor(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection conexao = dao.conexaoUsuario();
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
