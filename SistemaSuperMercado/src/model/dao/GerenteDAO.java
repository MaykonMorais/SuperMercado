package model.dao;
import javax.swing.JOptionPane;

//import model.domain.Gerente;

public class GerenteDAO {
	
	public boolean autenticar(String login, String senha) {
		if(login.equals("admin") && senha.equals("admin")) {
			return true;
		}
		else {
			return false;
		}
	}
}
