package br.com.oficinaSoftware.resource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Cadastro implements Initializable {
	@FXML
	private void botaoVoltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

	@FXML
	private void botaoSalvar(ActionEvent event) throws IOException {
		//salvar
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
