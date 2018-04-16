package br.com.oficinaSoftware.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.resource.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class VerificaComSenhaController implements Initializable {

    @FXML
    private TextField idLogarEmail;
    @FXML
    private PasswordField idLogarSenha;
    @FXML
    private Label idLogarMessage;

   @FXML
    private void botaoAltera(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        String idVal;
        UsuarioDAO dao = new UsuarioDAO();

        String email = idLogarEmail.getText();
        String senha = idLogarSenha.getText();

        if(email.length() == 0 || senha.length() == 0){
            idLogarMessage.setText("Algum dos campos está vazio.");
        }else{
            idVal = dao.getValidaPraLogar(email, senha) ;
            if (idVal != null) {
                Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/UpdateUsuario.fxml"));
                Scene scene = new Scene(root);
                Main.myStage.setScene(scene);
            }else {
                idLogarMessage.setText("Email ou senha incorretos.");
            }
        }

    }

    @FXML
    private void btVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/PerfilUsuario.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
