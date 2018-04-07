package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.resource.PerfilUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilUsuarioController {

	private UsuarioDAO dao = new UsuarioDAO();
	private PerfilUsuario perfilUsuario = new PerfilUsuario();

	public void populaPerfil(String _id) throws ClassNotFoundException, SQLException {
		ResultSet rs = dao.buscarPerfil(_id);
		perfilUsuario.popularTela(rs);
	}

}