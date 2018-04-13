package br.com.oficinaSoftware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.oficinaSoftware.controller.LoginController;
import br.com.oficinaSoftware.entity.Usuario;
import br.com.oficinaSoftware.entity.Fornecedor;

public class UsuarioDAO {

	private Connection conexaoUsuario() throws SQLException, ClassNotFoundException {
		String url ="jdbc:postgresql://localhost:5432/OI";
        String usuario="postgres";
        String senha = "postgres";

        Class.forName("org.postgresql.Driver");
        Connection conexao = DriverManager.getConnection(url,usuario,senha);

        return conexao;
	}

	public void salvarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException, ParseException {
		Connection conexao = conexaoUsuario();
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
		stmt.setInt(10, Integer.parseInt("1"));
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = data.parse(usuario.getDataNasc());
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		stmt.setDate(11, Date.valueOf(dt1.format(date)));

        stmt.executeUpdate();
	}


	public String getValidaPraLogar(String email, String senha) throws ClassNotFoundException, SQLException {
		Connection conexao = conexaoUsuario();
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
		Connection conexao = conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("SELECT nome, cargo, telefone, endereco, email,datanascimento FROM usuario WHERE usuario._id= \'" + _id + "\';");
		ResultSet rs = stmt.executeQuery();

		Usuario u = new Usuario();
		if(rs.next()) {
			u.setNome(rs.getString("nome"));
			u.setTelefone(rs.getString("telefone"));
			u.setCargo(rs.getString("cargo"));
			u.setEndereco(rs.getString("endereco"));
			u.setEmail(rs.getString("email"));
			u.setDataNasc(String.valueOf(rs.getDate("datanascimento")));
		}
		return u;
	}
}
