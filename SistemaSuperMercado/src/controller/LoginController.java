package controller;
import model.dao.GerenteDAO;

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
	
	@FXML protected void autenticar(ActionEvent event) {
		gerente = new GerenteDAO();
		
		gerente.autenticar(login.getText(), senha.getText());
	}
}
