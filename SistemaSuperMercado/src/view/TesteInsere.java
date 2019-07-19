package view;

import model.domain.Contatos;
import model.dao.ContatosDAO;
import model.database.*;

public class TesteInsere {
	public static void main(String args[]) {
		ContatosDAO dao = new ContatosDAO();
		Contatos c = new Contatos();
		
		c.setId(8828);
		c.setNome("Trollminhas");
		c.setEmail("thomas@gmail.com");
		c.setEndereco("rua sao joao");
		
		dao.adicionar(c);
	}
}
