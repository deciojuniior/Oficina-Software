package br.com.oficinaSoftware.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import br.com.oficinaSoftware.entity.Produto;
import br.com.oficinaSoftware.dao.ProdutoDAO;
import javafx.scene.input.InputMethodTextRun;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CadastroProdutoController implements Initializable {

    @FXML
    private TextField idNomeProduto;
    @FXML
    private TextField idQtdProduto;
    @FXML
    private TextField idValorCompra;
    @FXML
    private TextField idValorVenda;
    @FXML
    private TextField idPorcLucro;
    @FXML
    private TextField idQtdEstoque;



    @FXML
    private void botaoSalvar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
       // if(verificaSeEstaVazio()){
          //  idMessage.setText("Algum campo estar vazio.");
        //}else{
            Produto p = new Produto();
            String idUserF = LoginController.idValor;

            p.setNomeProduto(idNomeProduto.getText());
            p.setQtdProduto(Integer.valueOf(idQtdProduto.getText()));
            p.setPrecoProduto(Float.valueOf(idValorCompra.getText()));
            p.setVendaProduto(Float.valueOf(idValorVenda.getText()));
            p.setIdUsuario(Integer.valueOf(idUserF));
            p.setIdFornecedor(1);


            ProdutoDAO dao = new ProdutoDAO();
            dao.salvarProduto(p);

        //}
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
