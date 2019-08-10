package view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal extends Application {
	
	private static Stage stage; // palco que ira mudar 
	
	public void start(Stage stage) {
		stage.setTitle("Login Funcionario");
		setStage(stage);
		telaLogin();
	}
	
	// setar palcos
	public static void setStage(Stage palco) {
		stage = palco;
		
	}
	
	public void telaLogin() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginJFX.fxml"));
			
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void telaProdutos() {
		try {
			Parent tela = FXMLLoader.load(getClass().getResource("TelaProdutos.fxml"));
			
			Scene scene = new Scene(tela);
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void telaGerente() {
		try {
			Parent tela = FXMLLoader.load(getClass().getResource("telaGerente.fxml"));
			
			Scene scene = new  Scene(tela);
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void telaHistorico() {
		try {
			Parent tela = FXMLLoader.load(getClass().getResource("telaHistorico.fxml"));
			
			Scene scene = new Scene(tela);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		launch();
	}
	
	public void telaPagamento() {
		try {
			Parent tela = FXMLLoader.load(getClass().getResource("telaPagamento.fxml"));
			
			Scene scene = new  Scene(tela);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}