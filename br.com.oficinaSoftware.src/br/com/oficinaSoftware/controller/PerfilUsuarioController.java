package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilUsuarioController {

	private UsuarioDAO dao = new UsuarioDAO();

	public void populaPerfil(String email, String senha) throws ClassNotFoundException, SQLException {

		ResultSet rs = dao.buscarPerfil(email, senha);

		Usuario user = new Usuario();
		if (rs.next()) {
			user = new Usuario();
			user.setNome(rs.getString("nome"));
			user.setCargo(rs.getString("cargo"));
			user.setTelefone(rs.getString("telefone"));
			user.setEndereco(rs.getString("endereco"));
			user.setSenha(rs.getString("senha"));
		}
	}

}