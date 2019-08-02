package model.principal;

import java.sql.*;


import model.database.ConnectionFactory;

public class LoginModelGerente {

public boolean verificaGerente(String usuario, String senha) {		
		Connection con =  ConnectionFactory.getConnection(); 
		String sql= "select funcionario.nomeFuncionario, Gerente.senhaGerente from gerente inner join Funcionario using(idFuncionario)";
	
		try {
		
			PreparedStatement recebe = con.prepareStatement(sql); // conecta sql
			ResultSet verificaBD = recebe.executeQuery();// faz a requisição do sql
			
			while(verificaBD.next()) {	
				if(verificaBD.getString(1).equals(usuario)) {// pega do sql e compara
					if(verificaBD.getString(2).equals(senha)) {	
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
