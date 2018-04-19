package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.EstadoDAO;
import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Estado;
import br.com.oficinaSoftware.entity.Usuario;
import br.com.oficinaSoftware.resource.Main;
import br.com.oficinaSoftware.util.TextFieldFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;




import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.sql.SQLException;
import java.util.List;
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
    private TextField idConfEmail;
    @FXML
    private PasswordField idSenha;
    @FXML
    private PasswordField idConfSenha;
    @FXML
    private ComboBox<String> btCidade;
    @FXML
    private TextField idPergunta;
    @FXML
    private TextField idResposta;
    @FXML
    private TextField idDataNascimento;
    @FXML
    private ComboBox<Estado> btEstado;
    @FXML
    private Label idMessage;
    

    @FXML
    private void botaoVoltar(ActionEvent event) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);*/
        System.out.println(btEstado.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void botaoCadastrar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, ParseException {
        if(verificaSeEstaVazio()){
            idMessage.setText("Algum campos estar vazio.");
        }else{
            if (senhaValida() && emailValida()){
                Usuario u = new Usuario();


               // Date data = Date.from(Instant.parse(idDataNascimento.getText()));

                u.setNome(idNome.getText());
                u.setCpf(idCpf.getText());
                u.setEndereco(idEndereco.getText());
                u.setCargo(idCargo.getText());
                u.setTelefone(idTelefone.getText());
                u.setEmail(idEmail.getText());
                u.setSenha(idSenha.getText());
//                u.setCidade(idCidade.getText());
                u.setPergunta(idPergunta.getText());
                u.setResposta(idResposta.getText());
                u.setDataNasc(idDataNascimento.getText());


                UsuarioDAO dao = new UsuarioDAO();

                dao.salvarUsuario(u);
                limpaCampos();
            }else {
                idMessage.setText("Email ou Senhas invalidos.");
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
        //idCidade.setText("");
        idPergunta.setText("");
        idResposta.setText("");
        idDataNascimento.setText("");

    }

    private boolean senhaValida(){
        if(idSenha.getText().equals(idConfSenha.getText()) && idSenha.getText().length() >= 4){
            return true;
        }else {
            return false;
        }
    }
    private boolean emailValida(){
        if(idEmail.getText().equals(idConfEmail.getText())){
            return true;
        }else {
            return false;
        }
    }
    private boolean verificaSeEstaVazio() {
        return  idNome.getText().isEmpty() ||
                idCpf.getText().isEmpty() ||
                idDataNascimento.getText().isEmpty()||
                idEndereco.getText().isEmpty()||
                //idCidade.getText().isEmpty()||
                idCargo.getText().isEmpty()||
                idTelefone.getText().isEmpty()||
                idEmail.getText().isEmpty()||
                idSenha.getText().isEmpty()||
                idPergunta.getText().isEmpty()||
                idResposta.getText().isEmpty();
    }



    @FXML
    private void tbTelefone(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(idTelefone);
        tff.formatter();
    }


    @FXML
    private void tbCpf(){
        TextFieldFormatter tfC = new TextFieldFormatter();
        tfC.setMask("###.###.###-##");
        tfC.setCaracteresValidos("0123456789");
        tfC.setTf(idCpf);
        tfC.formatter();
    }
    @FXML
    private void tbDate(){
        TextFieldFormatter tfC = new TextFieldFormatter();
        tfC.setMask("##/##/####");
        tfC.setCaracteresValidos("0123456789");
        tfC.setTf(idDataNascimento);
        tfC.formatter();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
       EstadoDAO estado = new EstadoDAO();
       List<Estado> estados = null;
       try {
            estados = estado.buscarEstados();
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        }

        //ObservableList<Estado> listEstado;
        //chega null aqui
       //listEstado = FXCollections.observableArrayList(estados);
        btEstado.getItems().addAll(estados);

        listeners();
    }

    private void listeners(){
    	
        //========================CAIXA senha===========================
        idSenha.textProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue.length() > oldValue.length()){
                if(newValue.length() > 8)
                    idSenha.setText(oldValue);
            }
        });
        idConfSenha.textProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue.length() > oldValue.length()){
                if(newValue.length() > 8)
                    idConfSenha.setText(oldValue);
            }
        });


    }
}
