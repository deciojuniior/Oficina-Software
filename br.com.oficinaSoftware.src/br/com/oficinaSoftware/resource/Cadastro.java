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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Cadastro extends UsuarioController implements Initializable {

	@FXML
	private TextField idNome;
	@FXML
	private TextField idCpf;
	@FXML
	private TextField idEndereco;
	@FXML
	private TextField idCargo;
	@FXML
	private TextField idTelefone;
	@FXML
	private TextField idEmail;
	@FXML
	private PasswordField idSenha;
	@FXML
	private PasswordField idConfSenha;
	@FXML
	private Label idMessage;
	
	@FXML
	private void botaoVoltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

	@FXML
	private void botaoCadastrar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

		String retorno = getValidaPraSalvar(idNome.getText(), idCpf.getText(), idEndereco.getText(), idCargo.getText(),idTelefone.getText(), idEmail.getText(), idSenha.getText(), idConfSenha.getText());

		if (retorno.equals("")) {
			idNome.setText("");
			idCpf.setText("");
			idEndereco.setText("");
			idCargo.setText("");
			idTelefone.setText("");
			idEmail.setText("");
			idSenha.setText("");
			idConfSenha.setText("");
		}else {
			idMessage.setText(retorno);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
