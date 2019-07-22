package controller;

import model.dao.GerenteDAO;
import javafx.event.ActionEvent;
//import model.domain.Gerente;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginGerenteController {
	@FXML private TextField usuario;
	@FXML private PasswordField senha;
	@FXML private Label confirm;
	
	GerenteDAO gerente;
	
	@FXML protected void autenticarGerente(ActionEvent event) {
		gerente = new GerenteDAO();
		gerente.autenticar(usuario.getText(), senha.getText());
	}
}
