package model.dao;
import javax.swing.JOptionPane;

//import model.domain.Gerente;

public class GerenteDAO {
	
	public void autenticar(String login, String senha) {
		if(login.equals("admin") && senha.equals("admin")) {
			JOptionPane.showMessageDialog(null, "Logou");
		}
		else {
			JOptionPane.showMessageDialog(null, "senha incorreta");
		}
	}
}
