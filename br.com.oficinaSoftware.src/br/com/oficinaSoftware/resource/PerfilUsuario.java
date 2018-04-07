package br.com.oficinaSoftware.resource;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;


public class PerfilUsuario implements Initializable {

    @FXML
    private TextField idNomeP = new TextField();
    @FXML
    private TextField idEnderecoP = new TextField();
    @FXML
    private TextField idCargoP = new TextField();
    @FXML
    private TextField idTelefoneP = new TextField();
    @FXML
    private TextField idEmailP = new TextField();
    @FXML
    private TextField idIdadeP = new TextField();
    
    
    @FXML
    private void botaoVoltar (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }
    
    public void popularTela(ResultSet rs) throws SQLException {
    	while(rs.next()){
    	idNomeP.setText(rs.getString("nome"));
    	idCargoP.setText(rs.getString("cargo"));
    	idEmailP.setText(rs.getString("email"));
    	idEnderecoP.setText(rs.getString("endereco"));
    	idTelefoneP.setText(rs.getString("telefone"));
    	idIdadeP.setText("");
}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
}