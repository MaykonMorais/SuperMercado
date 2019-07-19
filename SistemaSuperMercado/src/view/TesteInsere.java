package view;

import model.domain.Contatos;
import model.dao.ContatosDAO;
import model.database.*;

public class TesteInsere {
	public static void main(String args[]) {
		ContatosDAO dao = new ContatosDAO();
		Contatos c = new Contatos();
		
		c.setId(23);
		c.setNome("smks");
		c.setEmail("thomas@gmail.com");
		c.setEndereco("rua sao joao");
		
		dao.adicionar(c);
	}
}
