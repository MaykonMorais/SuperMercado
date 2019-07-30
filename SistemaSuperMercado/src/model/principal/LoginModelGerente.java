package model.principal;

import java.sql.*;


import model.database.ConnectionFactory;

public class LoginModelGerente {
	public boolean verificaGerente(int idGerente, String senha) {
		
		Connection con =  ConnectionFactory.getConnection(); 
		String sql= "select * from gerente";
	
		try {
		
			PreparedStatement recebe = con.prepareStatement(sql); // conecta sql
			ResultSet verificaBD = recebe.executeQuery();// faz a requisição do sql
			while(verificaBD.next()) {
				
				if(verificaBD.getInt(2) == idGerente) {// pega do sql e compara
				
					if(verificaBD.getString(3).equals(senha)) {	
						return true;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
