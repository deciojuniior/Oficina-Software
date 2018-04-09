package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Usuario;
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
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {
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
        if(verificaSeEstaVazio()){
            idMessage.setText("Campos vazios.");
        }else{
            if (senhaValida()){
                Usuario u = new Usuario();

                u.setNome(idNome.getText());
                u.setCpf(idCpf.getText());
                u.setEndereco(idEndereco.getText());
                u.setCargo(idCargo.getText());
                u.setTelefone(idTelefone.getText());
                u.setEmail(idEmail.getText());
                u.setSenha(idSenha.getText());


                UsuarioDAO dao = new UsuarioDAO();

                dao.salvarUsuario(u);
                limpaCampos();
            }else {
                idMessage.setText("Senhas invalidas");
            }

        }
    }

    private void limpaCampos() {
        idNome.setText("");
        idCpf.setText("");
        idEndereco.setText("");
        idCargo.setText("");
        idTelefone.setText("");
        idEmail.setText("");
        idSenha.setText("");
        idConfSenha.setText("");
        idMessage.setText("");

    }
    private boolean senhaValida(){
        if(idSenha.getText().equals(idConfSenha.getText())){
            return true;
        }else {
            return false;
        }
    }

    private boolean verificaSeEstaVazio() {
        return idCargo.getText().isEmpty();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listeners();

    }

    private void listeners() {

        //========================CAIXA telefone===========================
        idTelefone.textProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue.length() > oldValue.length()){
                if(newValue.length() > 11)
                    idTelefone.setText(oldValue);
            }
                });
        //========================CAIXA CPF===========================
        idCpf.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > oldValue.length()){
                if(newValue.length() > 11){
                    //System.out.println("passou");
                    idCpf.setText(oldValue);
                }
            }
            //else{
             //   System.out.println("esta apagando");
            //}
            //System.out.println("oldvalue: "+oldValue);
            //System.out.println("newValue: "+newValue);
        });

    }
}
