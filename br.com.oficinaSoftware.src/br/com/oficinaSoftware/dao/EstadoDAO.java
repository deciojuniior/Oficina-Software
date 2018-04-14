package br.com.oficinaSoftware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.oficinaSoftware.entity.Estado;

public class EstadoDAO {

	DAO dao = new DAO();

	
	public List<Estado> buscarEstados() throws  ClassNotFoundException,SQLException,ParseException {
		Connection conexao = dao.conexaoUsuario();
		String sql = "select * from estado";
		PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();
		
		List<Estado> list  = new ArrayList<>();
		if (rs.next()){
			Estado estado = new Estado();
			estado.set_id(rs.getString("_id"));
			estado.setNome(rs.getString("nome"));
			estado.setUf(rs.getString("uf"));
			list.add(estado);
		}
		return list;
	}
}
