package br.com.oficinaSoftware.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import br.com.oficinaSoftware.resource.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


public class SenhaController implements Initializable {
    @FXML
    private Label idMensagem;

    @FXML
    private void btVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    public void setMensagem(){
        idMensagem.setText(PerguntaController.senhaUser);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMensagem();
    }
}
