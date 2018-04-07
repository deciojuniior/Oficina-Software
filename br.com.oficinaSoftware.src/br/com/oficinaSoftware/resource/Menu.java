package br.com.oficinaSoftware.resource;

import java.io.IOException;
import java.sql.SQLException;
import br.com.oficinaSoftware.controller.PerfilUsuarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Menu {
		
	private PerfilUsuarioController perfilUsuarioController =  new PerfilUsuarioController();
	
	@FXML
	private void botaoSair(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}
	@FXML
	private void botaoPerfil(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/PerfilUsuario.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
		
		perfilUsuarioController.populaPerfil("1");
	}
}
