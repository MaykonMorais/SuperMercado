package model.principal;

import java.sql.*;

import model.database.ConnectionFactory;

public class LoginModelGerente {
	public boolean verificaGerente(int idGerente, String senha) {
		
		Connection con =  ConnectionFactory.getConnection(); 
		return true;
	}
}