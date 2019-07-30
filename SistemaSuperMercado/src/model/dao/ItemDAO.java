package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionFactory;
import model.domain.Item;

public class ItemDAO {
	private Connection con;
	
	public ItemDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public  ObservableList<Item> consultaTotal() {
		PreparedStatement ps;
		ResultSet rs;
		
		ObservableList<Item> items = FXCollections.observableArrayList();
		
		try {
			ps = con.prepareStatement("select * from item");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Item item = new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
				//item.setIdItem(rs.getInt(1));
				//item.setMarcaItem(rs.getString(2));
				//item.setPrecoItem(rs.getDouble(4));
				//item.setQtdEstoque(rs.getInt(3));
				
				items.add(item);
				
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public ObservableList<Item> itemProcura(String marcaItem) {
		Connection con = ConnectionFactory.getConnection();
		Item item = null;
		
		ObservableList<Item> items = FXCollections.observableArrayList();

		String sql = "select * from item";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				if(rs.getString(2).equals(marcaItem)) {
					item = new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
					
					//item.setIdItem(rs.getInt(1));
					//item.setMarcaItem(rs.getString(2));
					//item.setPrecoItem(rs.getDouble(4));
					//item.setQtdEstoque(rs.getInt(3));
					items.add(item);
					
				}
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	}

}
