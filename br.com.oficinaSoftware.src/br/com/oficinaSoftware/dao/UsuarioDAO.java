package br.com.oficinaSoftware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import br.com.oficinaSoftware.entity.Usuario;

public class UsuarioDAO {
	
	DAO dao = new DAO();

	public String buscarSenhar(String per, String res) throws  ClassNotFoundException,SQLException,ParseException {
		Connection conexao = dao.conexaoUsuario();
		String sql = "select senha from usuario WHERE pergunta = \'"+per+"\' and resposta = \'"+res+"\';";
		PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();
		String valor = null;
		if (rs.next()){
			valor = rs.getString("senha");
		}
		return valor;

	}

	public void salvarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException, ParseException {
		Connection conexao = dao.conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Usuario(nome,cpf,cargo, endereco,telefone,email,senha,pergunta,resposta,_idcidade,datanascimento) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getCargo());
		stmt.setString(4, usuario.getEndereco());
		stmt.setString(5, usuario.getTelefone());
		stmt.setString(6, usuario.getEmail());
		stmt.setString(7, usuario.getSenha());
		stmt.setString(8, usuario.getPergunta());
		stmt.setString(9, usuario.getResposta());
		stmt.setInt(10, Integer.parseInt("57"));
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = data.parse(usuario.getDataNasc());
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		stmt.setDate(11, Date.valueOf(dt1.format(date)));

        stmt.executeUpdate();
	}


	public String getValidaPraLogar(String email, String senha) throws ClassNotFoundException, SQLException {
		Connection conexao = dao.conexaoUsuario();
		String sql = "SELECT _id FROM usuario WHERE usuario.email= \'"+email+"\'AND usuario.senha =\'"+senha+"\';";
		PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();
		String valor = null;
		if (rs.next()){
			valor = rs.getString("_id");
		}
		return valor; // retorna ID do usuario
	}

	public Usuario buscarUsuario(String _id) throws ClassNotFoundException, SQLException {
		Connection conexao = dao.conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("SELECT nome, cargo, telefone, endereco, email, datanascimento, cidade, estado, cpf, pergunta, resposta" +
				" FROM usuario_perfil WHERE _id= \'" + _id + "\';");
		ResultSet rs = stmt.executeQuery();

		Usuario u = new Usuario();
		if(rs.next()) {
			u.setNome(rs.getString("nome"));
			u.setTelefone(rs.getString("telefone"));
			u.setCargo(rs.getString("cargo"));
			u.setEndereco(rs.getString("endereco"));
			u.setEmail(rs.getString("email"));
			u.setDataNasc(String.valueOf(rs.getDate("datanascimento")));
			u.setCidade(rs.getString("cidade"));
			u.setEstado(rs.getString("estado"));
			u.setCpf(rs.getString("cpf"));
			u.setResposta(rs.getString("resposta"));
			u.setPergunta(rs.getString("pergunta"));
		}
		return u;
	}

	public void updateUsuario(String _id, Usuario u) throws ClassNotFoundException, SQLException {
		try {
		Connection conexao = dao.conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("UPDATE usuario SET nome =\'" + u.getNome() + "\',cpf =\'" + u.getCpf() + "\',cargo =\'" + u.getCargo() + "\', endereco =\'" + u.getEndereco() + "\', " +
				"telefone =\'" + u.getTelefone() + "\',email =\'" + u.getEmail() + "\',senha =\'" + u.getSenha() + "\',pergunta =\'" + u.getPergunta() + "\',resposta =\'" + u.getResposta() + "\' WHERE _id = \'" + _id + "\';");
		stmt.executeQuery();
		}catch (Exception e) {

		}

	}

}
