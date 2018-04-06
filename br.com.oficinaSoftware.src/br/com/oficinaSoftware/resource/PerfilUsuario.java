package br.com.oficinaSoftware.resource;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class PerfilUsuario {

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
    private void botaoVolta (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    public void teste() {
        idMessage.setText("VNSDJVKNSDKCJVBKZJXB");
    }
}