package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.EstadoDAO;
import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Estado;
import br.com.oficinaSoftware.entity.Usuario;
import br.com.oficinaSoftware.resource.Main;
import br.com.oficinaSoftware.util.TextFieldFormatter;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateUsuarioController implements Initializable {

    @FXML
    private TextField idNomeUp;
    @FXML
    private TextField idCpfUp;
    @FXML
    private TextField idEnderecoUp;
    @FXML
    private TextField idCargoUp;
    @FXML
    private TextField idTelefoneUp;
    @FXML
    private TextField idEmailUp;
    @FXML
    private TextField idConfEmailUp;
    @FXML
    private PasswordField idSenhaUp;
    @FXML
    private PasswordField idConfSenhaUp;
    @FXML
    private TextField idRespostaUp;
    @FXML
    private TextField idDataNascimentoUp;
    @FXML
    private TextField idPerguntaUp;
    @FXML
    private Label idMessageUp;
    @FXML
    private TextField idEmailAt;
    @FXML
    private PasswordField idSenhaAt;
    @FXML
    private ComboBox<Estado> btEstado;


    @FXML
    private void botaoVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/PerfilUsuario.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    @FXML
    private void botaoCadastrar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, ParseException {

        String idVal;
        UsuarioDAO dao = new UsuarioDAO();

        String email = idEmailAt.getText();
        String senha = idSenhaAt.getText();

        if(email.length() == 0 || senha.length() == 0){
            idMessageUp.setText("Insira e-mail e senha altual.");
        }else{
            idVal = dao.getValidaPraLogar(email, senha) ;
            if (idVal != null) {
                if(verificaSeEstaVazio()){
                    idMessageUp.setText("Algum campos estar vazio.");
                }else{
                    if (senhaValida() && emailValida()){
                        Usuario u = new Usuario();


                        // Date data = Date.from(Instant.parse(idDataNascimento.getText()));

                        u.setNome(idNomeUp.getText());
                        u.setCpf(idCpfUp.getText());
                        u.setEndereco(idEnderecoUp.getText());
                        u.setCargo(idCargoUp.getText());
                        u.setTelefone(idTelefoneUp.getText());
                        u.setEmail(idEmailUp.getText());
                        u.setSenha(idSenhaUp.getText());
                        //u.setCidade(btCidadeUp.add());
                        u.setPergunta(idPerguntaUp.getText());
                        u.setResposta(idRespostaUp.getText());
                        u.setDataNasc(idDataNascimentoUp.getText());

                        String idValor = LoginController.idValor;


                        dao.updateUsuario(idValor,u);
                        limpaCampos();
                    }else {
                        idMessageUp.setText("Email ou Senhas invalidos.");
                    }

                }



            }else {
                idMessageUp.setText("Email ou senha incorretos.");
            }
        }




    }

    private void limpaCampos() throws SQLException, ClassNotFoundException {
        idNomeUp.setText("");
        idCpfUp.setText("");
        idEnderecoUp.setText("");
        idCargoUp.setText("");
        idTelefoneUp.setText("");
        idEmailUp.setText("");
        idSenhaUp.setText("");
        idConfSenhaUp.setText("");
        idMessageUp.setText("");
//        btCidadeUp.setText("");
        idPerguntaUp.setText("");
        idRespostaUp.setText("");
        idDataNascimentoUp.setText("");
        idConfSenhaUp.setText("");
        idConfEmailUp.setText("");
        idEmailAt.setText("");
        idSenhaAt.setText("");

        UsuarioDAO dao = new UsuarioDAO();
        String idUser = LoginController.idValor;
        PerfilUsuarioController.USUARIO_LOGADO = dao.buscarUsuario(idUser);

    }

    private boolean senhaValida(){
        if(idSenhaUp.getText().equals(idConfSenhaUp.getText()) && idSenhaUp.getText().length() >= 4){
            return true;
        }else {
            return false;
        }
    }
    private boolean emailValida(){
        if(idEmailUp.getText().equals(idConfEmailUp.getText())){
            return true;
        }else {
            return false;
        }
    }
    private boolean verificaSeEstaVazio() {
        return  idNomeUp.getText().isEmpty() ||
                idCpfUp.getText().isEmpty() ||
                idDataNascimentoUp.getText().isEmpty()||
                idEnderecoUp.getText().isEmpty()||
                idCargoUp.getText().isEmpty()||
                idTelefoneUp.getText().isEmpty()||
                idEmailUp.getText().isEmpty()||
                idSenhaUp.getText().isEmpty()||
                idPerguntaUp.getText().isEmpty()||
                idRespostaUp.getText().isEmpty();


    }



    @FXML
    private void tbTelefone(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(idTelefoneUp);
        tff.formatter();
    }


    @FXML
    private void tbCpf(){
        TextFieldFormatter tfC = new TextFieldFormatter();
        tfC.setMask("###.###.###-##");
        tfC.setCaracteresValidos("0123456789");
        tfC.setTf(idCpfUp);
        tfC.formatter();
    }

    @FXML
    private void tbDate(){
        TextFieldFormatter tfC = new TextFieldFormatter();
        tfC.setMask("##/##/####");
        tfC.setCaracteresValidos("0123456789");
        tfC.setTf(idDataNascimentoUp);
        tfC.formatter();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 	   EstadoDAO estado = new EstadoDAO();
       List<Estado> estados = null;
       try {
            estados = estado.buscarEstados();
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        }
       
        btEstado.getItems().addAll(estados);

        idNomeUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getNome());
        idCpfUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getCpf());
        idEnderecoUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getEndereco());
        idCargoUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getCargo());
        idTelefoneUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getTelefone());
        idEmailUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getEmail());
        idConfEmailUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getEmail());
        idPerguntaUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getPergunta());
        idRespostaUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getResposta());
        idDataNascimentoUp.setText(PerfilUsuarioController.USUARIO_LOGADO.getDataNasc());
//      btEstado.set(PerfilUsuarioController.USUARIO_LOGADO.getEstado());
//        btCidadeUp.setVisibleRowCount(PerfilUsuarioController.USUARIO_LOGADO.getCidade());

    }
}


