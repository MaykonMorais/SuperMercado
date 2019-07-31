package controller;
import model.dao.GerenteDAO;
import model.domain.Funcionario;
import model.domain.Gerente;
import model.principal.LoginModelFuncionario;
import model.principal.LoginModelGerente;
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
	private LoginModelGerente g;
	private Principal tela;
	
	@FXML protected void autenticar(ActionEvent event) {		
		boolean pass;
		
		if(verifica.isSelected()) {
			g = new LoginModelGerente();
			
			pass = g.verificaGerente(login.getText(), senha.getText());
			if(pass) {
				tela = new Principal();
				tela.telaGerente();
			} else {
				JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos!");
			}
		}
		
		else {
			f = new LoginModelFuncionario();
			
			pass = f.verificaFuncionario(login.getText(), senha.getText());
			
			if(pass) {
				tela = new Principal();
				tela.telaProdutos();
			}
			else {
				JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos!");
			}
		}
	}
}
