package br.com.oficinaSoftware.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.control.TextField;

public class PerguntaController implements Initializable {

    @FXML
    private TextField idPergunta;
    @FXML
    private TextField idResposta;
    @FXML
    private Label idMensagem;

    @FXML
    private void btVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    @FXML
    private void btVerSenha(ActionEvent event) throws ParseException, SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        String senhaUser;


        String perg = idPergunta.getText();
        String resp = idResposta.getText();

        if(perg.length() == 0 || resp.length() == 0){
            idMensagem.setText("Algum dos campos esta vazio.");
        }else{
            senhaUser = dao.buscarSenhar(perg,resp) ;
            if (senhaUser != null) {
                idMensagem.setText("Sua senha e "+senhaUser);
            }else {
                idMensagem.setText("Não encontrado");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
