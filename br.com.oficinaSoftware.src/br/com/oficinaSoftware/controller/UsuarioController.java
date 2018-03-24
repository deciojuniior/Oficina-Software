package br.com.oficinaSoftware.controller;

import java.sql.SQLException;
import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Usuario;

public class UsuarioController {

	private UsuarioDAO dao = new UsuarioDAO();

	public String getValidaPraSalvar(String nome, String cpf, String endereco, String cargo, String telefone,String email, String senha, String confirmaSenha) throws ClassNotFoundException, SQLException {
		Usuario usuario = new Usuario();
		String retorno = "";
		if (nome.length() != 0 && senha.length() != 0 && confirmaSenha.length() != 0 && email.length() != 0	&& cpf.length() != 0 && endereco.length() != 0 && cargo.length() != 0 && telefone.length() != 0) {
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
				retorno = "As senhas informadas estão diferentes.";
			}
		} else {
			retorno =  "Campos obrigatórios não preenchidos.";
		}
		return retorno;
	}
}