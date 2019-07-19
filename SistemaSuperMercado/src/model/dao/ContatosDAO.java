package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.database.*;
import model.domain.*;

public class ContatosDAO {
		private Connection con;
		
		public ContatosDAO() {
			this.con = ConnectionFactory.getConnection();	
		}
		
		public void adicionar(Contatos c) {
			String sql = "insert into contatos values (?, ?, ?, ?)";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, c.getId());
				ps.setString(2, c.getNome());
				ps.setString(3, c.getEmail());
				ps.setString(4, c.getEndereco());
				
				ps.execute();
				ps.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Deu certo");
		}
}
