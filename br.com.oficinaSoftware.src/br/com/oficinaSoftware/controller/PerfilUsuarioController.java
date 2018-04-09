package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.entity.Usuario;
import br.com.oficinaSoftware.resource.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PerfilUsuarioController implements Initializable {

	@FXML private TextField idNomeP;
	@FXML private TextField idEnderecoP;
	@FXML private TextField idCargoP;
	@FXML private TextField idTelefoneP;
	@FXML private TextField idEmailP;
	@FXML private TextField idIdadeP;

	public static Usuario USUARIO_LOGADO;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idNomeP.setText(USUARIO_LOGADO.getNome());
		idEnderecoP.setText(USUARIO_LOGADO.getEndereco());
		idCargoP.setText(USUARIO_LOGADO.getCargo());
		idTelefoneP.setText(USUARIO_LOGADO.getTelefone());
		idEmailP.setText(USUARIO_LOGADO.getEmail());

	}

	@FXML private void botaoVoltar (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

}