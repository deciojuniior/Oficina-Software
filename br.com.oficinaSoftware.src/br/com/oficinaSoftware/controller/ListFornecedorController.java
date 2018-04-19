package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.FornecedorDAO;
import br.com.oficinaSoftware.entity.Fornecedor;
import br.com.oficinaSoftware.resource.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListFornecedorController implements Initializable {

    @FXML
    private TableView <Fornecedor> tbFornecedor;
    @FXML
    private TableColumn <Fornecedor, String> tcNomeFor;
    @FXML
    private TableColumn <Fornecedor, String> tcCnpjFor;
    @FXML
    private TableColumn <Fornecedor, String> tcEnderecoFor;

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
        confTabela();
        populaTabela();
    }

    public void confTabela (){
        tcNomeFor.setCellValueFactory(celula->new SimpleStringProperty(celula.getValue().getNomeFornecedor()));
        tcCnpjFor.setCellValueFactory(celula->new SimpleStringProperty(celula.getValue().getCnpjFornecedor()));
        tcEnderecoFor.setCellValueFactory(celula->new SimpleStringProperty(celula.getValue().getEnderecoFornecedor()));
    }

    public void populaTabela (){

        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> fornecedorList = null;
        try {
            fornecedorList = dao.buscarFornecedor();
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        }

        tbFornecedor.getItems().addAll(fornecedorList);

    }
}
