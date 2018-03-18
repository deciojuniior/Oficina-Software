package br.com.oficinaSoftware.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Usuario(nome, email, senha) VALUES (?, ?, ?)");

		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setString(3, usuario.getSenha());

		stmt.executeUpdate();
	}
}
