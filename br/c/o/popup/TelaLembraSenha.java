package br.c.o.popup;

import br.com.oficinaSoftware.resource.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLembraSenha extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage){
        try {
            TelaLembraSenha.stage = stage;
            Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Pergunta.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Lembrar Senha");
            //stage.getIcons().add(new Image("endereço imagem icone janela"));
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.out.println("Erro na tela lembrar senha" + e.getMessage());
        }

    }
    public static void fechar(){
        TelaLembraSenha.stage.close();
        TelaLembraSenha.stage = null;
    }
}
