package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.resource.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private void botaoSair(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void botaoPerfil(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

        UsuarioDAO dao = new UsuarioDAO();

        PerfilUsuarioController.USUARIO_LOGADO = dao.buscarUsuario("1");

        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/PerfilUsuario.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);



    }
}
