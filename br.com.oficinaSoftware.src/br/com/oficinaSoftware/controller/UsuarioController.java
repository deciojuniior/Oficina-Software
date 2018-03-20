package br.com.oficinaSoftware.controller;

import java.sql.SQLException;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Usuario;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioController {
	private UsuarioDAO dao = new UsuarioDAO();

	public void getValidaPraSalvar(TextField nome, TextField email, PasswordField senha, PasswordField confirmaSenha)throws ClassNotFoundException, SQLException {
		Usuario usuario = new Usuario();
		if (nome.getText().length() != 0 && senha.getText().length() != 0 && confirmaSenha.getText().length() != 0 && email.getText().length() != 0) {
			if (senha.getText().equals(confirmaSenha.getText())) {
				usuario.setEmail(email.getText());
				usuario.setNome(nome.getText());
				usuario.setSenha(senha.getText());
				dao.salvarUsuario(usuario);
			}else {
				System.out.println("As senhas estão diferentes");
			}
		}else {
			System.out.println("Campos obrigatórios não preenchidos");
		}
	}
}
