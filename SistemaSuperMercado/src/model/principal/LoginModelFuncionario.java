package model.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.ConnectionFactory;

public class LoginModelFuncionario implements LoginFuncionarios{
	public boolean verificaFuncionario(String nomeFuncionario,String senhaFuncionario) {
		Connection conect = ConnectionFactory.getConnection();
		String sql= "select * from Funcionario";
		
		try {
			PreparedStatement recebe = conect.prepareStatement(sql);
			ResultSet verificaBD = recebe.executeQuery();
			
			while(verificaBD.next()) {
				if(verificaBD.getString(2).equals(nomeFuncionario)) {
						if(verificaBD.getString(3).equals(senhaFuncionario)) {
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

