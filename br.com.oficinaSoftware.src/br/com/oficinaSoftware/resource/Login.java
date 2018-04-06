package br.com.oficinaSoftware.resource;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.oficinaSoftware.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login extends LoginController implements Initializable{

	@FXML
	private TextField idLogarEmail;
	@FXML
	private PasswordField idLogarSenha;
	@FXML
	private Label idLogarMessage;

	@FXML
	private void botaoLogar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		
		String retorno = getValidaPraLogar(idLogarEmail.getText(), idLogarSenha.getText());

		if (retorno.equals("")) {
			Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
			Scene scene = new Scene(root);
			Main.myStage.setScene(scene);
			}else {
			idLogarMessage.setText(retorno);
		}
	}


	@FXML
	private void botaoCadastrar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Cadastro.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
