package br.com.oficinaSoftware.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

	@SuppressWarnings("rawtypes")
	private TableView table = new TableView();
	private GridPane grid = new GridPane();
	private final Text acaoClick = new Text();
	private TextField usuario = new TextField();
	private PasswordField password = new PasswordField();
	private Button btnLogin = new Button("Entrar");
	private Button btnCadastrar = new Button("Cadastrar");
	private HBox hbBtnLogin = new HBox(10);
	private HBox hbBtnCadastrar = new HBox(10);
	private Scene scene = new Scene(grid, 1400, 700);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		grid.setPadding(new Insets(25, 25, 25, 25));

		grid.add(table, 0, 1, 9, 9);

		grid.add(acaoClick, 4, 5);
		acaoClick.setId("acaoClick");

		usuario.setPromptText("Email");
		grid.add(usuario, 4, 6);

		password.setPromptText("Senha");
		grid.add(password, 4, 7);

		btnLogin.setPrefSize(200, 0);
		hbBtnLogin.getChildren().add(btnLogin);
		grid.add(hbBtnLogin, 4, 8);

		btnCadastrar.setPrefSize(200, 0);
		hbBtnCadastrar.getChildren().add(btnCadastrar);
		grid.add(hbBtnCadastrar, 4, 9);

		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				acaoClick.setText("Voce clicou em entrar");
//				   @Override public void handle(ActionEvent e) {
//				        if (!pb.getText().equals("T2f$Ay!")) {
//				            message.setText("Your password is incorrect!");
//				            message.setTextFill(Color.rgb(210, 39, 30));
//				        } else {
//				            message.setText("Your password has been confirmed");
//				            message.setTextFill(Color.rgb(21, 117, 84));
//				        }
//				        pb.clear();
//				    }
			}
		});

		btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				final Cadastro cadastro = new Cadastro();
				cadastro.start(primaryStage);
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
