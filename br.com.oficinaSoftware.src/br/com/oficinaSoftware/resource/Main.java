package br.com.oficinaSoftware.resource;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static Scene SCENE;
	public static Stage myStage;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws IOException {
		Parent root;

		root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Login.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		myStage = primaryStage;
		primaryStage.show();
	}
}