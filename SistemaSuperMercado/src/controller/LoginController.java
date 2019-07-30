package controller;
import model.dao.GerenteDAO;
import model.principal.LoginModelFuncionario;
import view.Principal;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private Label confirm;
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private CheckBox verifica;
	
	private LoginModelFuncionario f;
	private Principal tela;
	
	@FXML protected void autenticar(ActionEvent event) {
		f = new LoginModelFuncionario(); // exemplo
		
		boolean pass = f.verificaFuncionario(login.getText(), senha.getText());
		
		if(verifica.isSelected()) {
			tela = new Principal();
			tela.telaGerente();
		}	
	}
}
