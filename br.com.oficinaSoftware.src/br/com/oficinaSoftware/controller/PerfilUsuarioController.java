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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class PerfilUsuarioController implements Initializable {

	@FXML
	private TextField idNomeP;
	@FXML
	private TextField idEnderecoP;
	@FXML
	private TextField idCargoP;
	@FXML
	private TextField idTelefoneP;
	@FXML
	private TextField idEmailP;
	@FXML
	private TextField idIdadeP;
	@FXML
	private TextField idCidade;
	@FXML
	private TextField idEstado;

	public static Usuario USUARIO_LOGADO;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idNomeP.setText(USUARIO_LOGADO.getNome());
		idEnderecoP.setText(USUARIO_LOGADO.getEndereco());
		idCargoP.setText(USUARIO_LOGADO.getCargo());
		idTelefoneP.setText(USUARIO_LOGADO.getTelefone());
		idEmailP.setText(USUARIO_LOGADO.getEmail());
		idCidade.setText(USUARIO_LOGADO.getCidade());
		idEstado.setText(USUARIO_LOGADO.getEstado());
		Long idade = 0L;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String hoje = sdf.format(new Date(System.currentTimeMillis()));
			java.util.Date dataDe = sdf.parse(hoje);
			java.util.Date dataAte = sdf.parse(USUARIO_LOGADO.getDataNasc());
			idade = (((dataAte.getTime() - dataDe.getTime()) / (1000 * 60 * 60 * 24) / 30) / 12) * -1;
		} catch (Exception e) {
		}
		idIdadeP.setText(String.valueOf(idade));
	}

	@FXML
	private void botaoVoltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

	@FXML
	private void btAlterarPerfil(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/VerificaComSenha.fxml"));
		Scene scene = new Scene(root);
		Main.myStage.setScene(scene);
	}

}