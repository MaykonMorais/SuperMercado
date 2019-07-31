package controller;
import model.dao.GerenteDAO;
import model.principal.LoginModelFuncionario;
import model.principal.LoginModelGerente;
import view.*;

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
	private LoginModelGerente G;
	
	private Principal tela;
	
	@FXML protected void autenticar(ActionEvent event) {
		boolean pass;
		G = new LoginModelGerente();
		
			 pass = G.verificaGerente(login.getText(), senha.getText());
		if(pass) {
			tela = new Principal();
			tela.telaProdutos();
		}else {
		f = new LoginModelFuncionario(); // exemplo
		 pass = f.verificaFuncionario(login.getText(), senha.getText());
		
		 if(pass) {
			tela = new Principal();
			tela.telaProdutos();
		 }
		}
	}
}
