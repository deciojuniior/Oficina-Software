package br.com.oficinaSoftware.dao;


import br.com.oficinaSoftware.entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    DAO dao = new DAO();
    public void salvarProduto(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = dao.conexaoUsuario();
        PreparedStatement stmt = conexao.prepareStatement("INSERT INTO produto(nome,quantidade,preco,valor_compra,_idusuario,_idfornecedor) VALUES(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, produto.getNomeProduto());
        stmt.setInt(2, produto.getQtdProduto());
        stmt.setFloat(4, produto.getVendaProduto());
        stmt.setFloat(3, produto.getPrecoProduto());
        stmt.setInt(5, produto.getIdUsuario());
        stmt.setInt(6, produto.getIdFornecedor());

        stmt.executeUpdate();
    }
}
