package br.com.oficinaSoftware.controller;

import java.sql.SQLException;

import br.com.oficinaSoftware.dao.UsuarioDAO;

public class LoginController {

	private UsuarioDAO dao = new UsuarioDAO();

	public String getValidaPraLogar(String email, String senha) throws ClassNotFoundException, SQLException {
		String retorno = "";
		if (email.length() != 0 && senha.length() != 0) {
			int cont = dao.buscarUsuario(email, senha);
			if(cont == 0) {
				retorno = "Email e senha não cadastrados!";
			}
		} else {
			retorno = "Campos obrigatórios não preenchidos.";
		}
		return retorno;
	}
}
