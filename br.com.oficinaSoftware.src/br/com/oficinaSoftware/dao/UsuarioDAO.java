package br.com.oficinaSoftware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.oficinaSoftware.entity.Usuario;

public class UsuarioDAO {

	private Connection conexaoUsuario() throws SQLException, ClassNotFoundException {
		String url ="jdbc:postgresql://localhost:5432/OI";
        String usuario="postgres";
        String senha = "postgres";

        Class.forName("org.postgresql.Driver");
        Connection conexao = DriverManager.getConnection(url,usuario,senha);

        return conexao;
	}

	public void salvarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		Connection conexao = conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Usuario(nome,cpf,endereco,cargo,telefone,email,senha) VALUES (?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getCargo());
		stmt.setString(4, usuario.getEndereco());
		stmt.setString(5, usuario.getTelefone());
		stmt.setString(6, usuario.getEmail());
		stmt.setString(7, usuario.getSenha());

		stmt.executeUpdate();
	}

	/*public String idUsuario (String email, String senha) throws ClassNotFoundException, SQLException {
		Connection conexao = conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("SELECT _id FROM usuario WHERE usuario.email= \'" +email+ "\'AND usuario.senha =\'" +senha+"\';");
		ResultSet rs = stmt.executeQuery();

		String u = new String();
		if(rs.next()) {
			u..rs.getString("_id"));
			u.setNome(rs.getString("nome"));
			u.setTelefone(rs.getString("telefone"));
			u.setCargo(rs.getString("cargo"));
			u.setEndereco(rs.getString("endereco"));
			u.setEmail(rs.getString("email"));
		}
		return sql;
	}*/

	public String getValidaPraLogar(String email, String senha) throws ClassNotFoundException, SQLException {
		Connection conexao = conexaoUsuario();
		String sql = "SELECT _id FROM usuario WHERE usuario.email= \'"+email+"\'AND usuario.senha =\'"+senha+"\';";
		PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();
		String valor = null;
		if (rs.next()){
			valor = rs.getString("_id");
		}
		return valor; // se achar algo retorna verdadeiro, senao falso
	}

	public Usuario buscarUsuario(String _id) throws ClassNotFoundException, SQLException {
		Connection conexao = conexaoUsuario();
		PreparedStatement stmt = conexao.prepareStatement("SELECT nome, cargo, telefone, endereco, email FROM usuario WHERE usuario._id= \'" + _id + "\';");
		ResultSet rs = stmt.executeQuery();

		Usuario u = new Usuario();
		if(rs.next()) {
			//u.set_id(rs.getString("_id"));
			u.setNome(rs.getString("nome"));
			u.setTelefone(rs.getString("telefone"));
			u.setCargo(rs.getString("cargo"));
			u.setEndereco(rs.getString("endereco"));
			u.setEmail(rs.getString("email"));
		}
		return u;
	}
}
