package br.com.oficinaSoftware.resource;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.oficinaSoftware.controller.UsuarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Cadastro extends UsuarioController implements Initializable{

	@FXML
	TextField idNome;
	@FXML
	TextField idCpf;
	@FXML
	TextField idEndereco;
	@FXML
	TextField idCargo;
	@FXML
	TextField idTelefone;
	@FXML
	TextField idEmail;
	@FXML
	PasswordField idSenha;
	@FXML
	PasswordField idConfSenha;

	@FXML
	private void botaoVoltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

	@FXML
	private void botaoCadastrar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
	getValidaPraSalvar(idNome.getText(), idCpf.getText(), idEndereco.getText(), idCargo.getText(),
				idTelefone.getText(), idEmail.getText(), idSenha.getText(), idConfSenha.getText());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
