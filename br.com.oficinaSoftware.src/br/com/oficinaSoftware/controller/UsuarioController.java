package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.entity.Usuario;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioController {

	public Usuario getValidaPraSalvar(TextField nome, TextField email, PasswordField senha,PasswordField confirmaSenha) {
		Usuario usuario = new Usuario();
		if (nome != null && senha != null && confirmaSenha != null && email != null) {
			if (senha.getText().equals(confirmaSenha.getText())) {
				usuario.setEmail(email.getText());
				usuario.setNome(nome.getText());
				usuario.setSenha(senha.getText());
			}
		}
		return usuario;
	}
}
