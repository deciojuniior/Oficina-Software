package br.com.oficinaSoftware.view;

import java.sql.SQLException;

import br.com.oficinaSoftware.controller.UsuarioController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Cadastro extends Application {

	@SuppressWarnings("rawtypes")
	private TableView table = new TableView();
	private GridPane grid = new GridPane();
	private final Text acaoClick = new Text();
	private TextField nome = new TextField();
	private TextField email = new TextField();
	private PasswordField senha = new PasswordField();
	private PasswordField confirmaSenha = new PasswordField();
	private Label lbNome = new Label("Nome:");
	private Label lbEmail = new Label("Email:");
	private Label lbSenha = new Label("Senha:");
	private Label lbConfirmaSenha = new Label("Confirma Senha:");
	private Button btnVoltar = new Button("Voltar");
	private Button btnSalvar = new Button("Salvar");
	private HBox hbBtnVoltar = new HBox(10);
	private HBox hbBtnSalvar = new HBox(10);
	private Scene scene = new Scene(grid, 1400, 700);
	
	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage) {
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		grid.add(table, 0, 1, 18, 16);

		grid.add(acaoClick, 4, 5);
		acaoClick.setId("acaoClick");

		grid.add(lbNome, 7, 4);
		nome.setPromptText("Nome");
		nome.setPrefSize(300, 0);
		grid.add(nome, 7, 5);
		
		grid.add(lbEmail, 11, 4);
		email.setPromptText("E-mail");
		email.setPrefSize(300,0);
		grid.add(email, 11, 5);
		
		grid.add(lbSenha, 7, 7);
		senha.setPromptText("Senha");
		senha.setPrefSize(300,0);
		grid.add(senha, 7, 8);
		
		grid.add(lbConfirmaSenha, 11, 7);
		confirmaSenha.setPromptText("Digite sua senha novamente");
		confirmaSenha.setPrefSize(200,0);
		grid.add(confirmaSenha, 11, 8);
		
		btnVoltar.setPrefSize(300, 0);
		hbBtnVoltar.getChildren().add(btnVoltar);
		grid.add(hbBtnVoltar, 7, 11);

		btnSalvar.setPrefSize(300, 0);
		hbBtnSalvar.getChildren().add(btnSalvar);
		grid.add(hbBtnSalvar, 11, 11);

		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final Login login = new Login();
				login.start(stage);
			}
		});

		btnSalvar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
					UsuarioController usuarioController = new UsuarioController();
					try {
						usuarioController.getValidaPraSalvar(nome, email, senha, confirmaSenha);
					} catch (ClassNotFoundException e1) {
						System.out.println(e1);
					} catch (SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		stage.setScene(scene);
		stage.show();
	}
}
