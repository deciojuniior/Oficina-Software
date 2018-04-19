package br.com.oficinaSoftware.dao;

import br.com.oficinaSoftware.controller.LoginController;
import br.com.oficinaSoftware.entity.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Fornecedor> buscarFornecedor() throws  ClassNotFoundException,SQLException, ParseException {
        Connection conexao = dao.conexaoUsuario();
        String sql = "SELECT * FROM fornecedor WHERE deletado = false;";
        PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery();

        List<Fornecedor> list  = new ArrayList<>();
        while (rs.next()){
            Fornecedor f = new Fornecedor();
            f.set_id(rs.getString("_id"));
            f.setNomeFornecedor(rs.getString("nome"));
            f.setTelefoneFornecedor(rs.getString("telefone"));
            f.setEnderecoFornecedor(rs.getString("endereco"));
            f.set_idUsuario(rs.getString("_idusuario"));
            f.setCnpjFornecedor(rs.getString("cnpj"));
            f.setEmailFornecedor(rs.getString("email"));
            list.add(f);
        }
        return list;
    }


}
