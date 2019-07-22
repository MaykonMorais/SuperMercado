package view; // tela que irá apresentar opcoes

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaLoginGerente extends Application {
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("loginGerenteJFX.fxml"));
			
			Scene scene = new Scene(root);
			stage.setTitle("SuperMercado Login");
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		launch();	
	}

}
