package br.com.oficinaSoftware.resource;

import java.io.IOException;

import br.com.oficinaSoftware.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;


public class PerfilUsuario {

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
    
	Usuario usuario;
    
    @FXML
    private void botaoVoltar (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }
    
    @FXML
    private void popularTela() {
    	idNomeP.setText(usuario.getNome());
    	idCargoP.setText(usuario.getCargo());
    	idEmailP.setText(usuario.getEmail());
    	idEnderecoP.setText(usuario.getEndereco());
    	idIdadeP.setText("");
    	idTelefoneP.setText(usuario.getTelefone());
    	
    }
}