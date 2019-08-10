// CONEXÃO COM O BANCO DE DADOS
package model.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection () {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Estudo-BD", "postgres", "Maintcmlixo1234");
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
