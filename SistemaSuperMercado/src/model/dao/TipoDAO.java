package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.database.ConnectionFactory;
import model.domain.Item;
import model.domain.Tipo;

public class TipoDAO {
	private Connection con;

	public TipoDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	public List<Tipo> procuraTipos() {
		PreparedStatement ps;
		ResultSet rs;
		
		List<Tipo> tipos = new ArrayList<Tipo>();
		
		try {
			ps = con.prepareStatement("select * from tipo");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Tipo tipo = new Tipo();
				tipo.setIdTipo(rs.getInt(1));
				tipo.setNomeTipo(rs.getString(2));
				tipo.setFormaVenda(rs.getString(3));
				
				
				tipos.add(tipo);
				
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipos;
	}
}
