package br.com.oficinaSoftware.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.resource.Menu;

public class LoginController {

	private UsuarioDAO dao = new UsuarioDAO();
	public Menu menu = new Menu();

	public String getValidaPraLogar(String email, String senha) throws ClassNotFoundException, SQLException {
		String retorno = "";
		if (email.length() != 0 && senha.length() != 0) {
			ResultSet rs = dao.buscarUsuario(email, senha);
			if (rs.next()) {
				if (rs.getString("_id") == null) {
					retorno = "Email e senha nao cadastrados!";
				} else {
				//(rs.getString("_id"));// Retornar o _id do usuário pra fazer as buscas
				}
			} else {
				retorno = "Email e senha nao cadastrados!";
			}
		} else {
			retorno = "Campos obrigatorios nao preenchidos.";
		}
		return retorno;
	}
}
