package controller;
import model.dao.GerenteDAO;
import view.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private Label confirm;
	@FXML private TextField login;
	@FXML private PasswordField senha;
	GerenteDAO gerente;
	private Principal tela;
	
	@FXML protected void autenticar(ActionEvent event) {
		gerente = new GerenteDAO(); // exemplo
		
		boolean pass = gerente.autenticar(login.getText(), senha.getText());
		if(pass) {
			tela = new Principal();
			tela.telaProdutos();
		}
		
	}
}
