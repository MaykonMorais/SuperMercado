package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.Gerente;
import model.database.ConnectionFactory;

//import model.domain.Gerente;

public class GerenteDAO {
	private Connection con;
	
	public GerenteDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
}
