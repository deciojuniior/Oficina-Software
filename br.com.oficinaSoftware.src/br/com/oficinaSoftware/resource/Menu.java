package br.com.oficinaSoftware.resource;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Menu {
	@FXML
	private void botaoSair(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

}
