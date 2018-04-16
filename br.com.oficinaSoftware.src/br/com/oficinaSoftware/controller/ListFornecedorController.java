package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.resource.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListFornecedorController implements Initializable {


    @FXML
    private void btVoltarM (javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }


    @FXML
    private void btCadastraFornecedor (javafx.event.ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/CadastroFornecedor.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
