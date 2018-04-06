package br.com.oficinaSoftware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.oficinaSoftware.entity.Usuario;

public class UsuarioDAO {

	protected Connection conc;


	public UsuarioDAO() {
		try {
			this.conc = conexaoUsuario();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

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

	public int buscarUsuario(String email, String senha) throws ClassNotFoundException, SQLException {
		Connection conexao = conexaoUsuario();
		String sql = "SELECT count(*) FROM usuario WHERE usuario.email= \'"+email+"\'AND usuario.senha =\'"+senha+"\';";
		PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = stmt.executeQuery();
		int cont = 0;
		if (resultSet.next()) {
		 cont = resultSet.getInt(1);
		}
		return cont;
	}

	public Usuario buscarPerfil(String email, String senha) throws ClassNotFoundException, SQLException {
		//ArrayList<Usuario> usuarios = new ArrayList<>();

		try {
			PreparedStatement stmt = conc.prepareStatement("SELECT nome, cargo, telefone, endereco, senha FROM usuario WHERE usuario.email= \'" + email + "\'AND usuario.senha =\'" + senha + "\';");
			//stmt.prepareStatement(stmt, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery();

			Usuario user;
			if (rs.next()) {
				user = new Usuario();
				//UsuarioDAO pf = new UsuarioDAO();

				user.setNome(rs.getString("nome"));
				user.setCargo(rs.getString("cargo"));
				user.setTelefone(rs.getString("telefone"));
				user.setEndereco(rs.getString("endereco"));
				user.setSenha(rs.getString("senha"));
				return user;
				//usuarios.add(user);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
