package br.com.oficinaSoftware.controller;

import java.sql.SQLException;
import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Usuario;

public class UsuarioController {

	private UsuarioDAO dao = new UsuarioDAO();

	public void getValidaPraSalvar(String nome, String cpf, String endereco, String cargo, String telefone,
			String email, String senha, String confirmaSenha) throws ClassNotFoundException, SQLException {
		Usuario usuario = new Usuario();
		if (nome.length() != 0 && senha.length() != 0 && confirmaSenha.length() != 0 && email.length() != 0
				&& cpf.length() != 0 && endereco.length() != 0 && cargo.length() != 0 && telefone.length() != 0) {
			if (senha.equals(confirmaSenha)) {
				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setEndereco(endereco);
				usuario.setCargo(cargo);
				usuario.setTelefone(telefone);
				usuario.setEmail(email);
				usuario.setSenha(senha);
				dao.salvarUsuario(usuario);
			} else {
				System.out.println("As senhas estão diferentes");
			}
		} else {
			System.out.println("Campos obrigatórios não preenchidos");
		}
	}

	public void getTeste() {
		System.out.println("AQUI");

	}
}
