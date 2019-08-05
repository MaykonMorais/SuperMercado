package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionFactory;
import model.domain.Item;

public class ItemDAO {
	private static Connection con;
	
	public ItemDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public List<Item> consultaTotal() {
		PreparedStatement ps;
		ResultSet rs;
		
		List<Item> items = new ArrayList<Item>();
		
		try {
			ps = con.prepareStatement("select * from item");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				item.setIdItem(rs.getInt(1));
				item.setMarcaItem(rs.getString(2));
				item.setPrecoItem(rs.getDouble(4));
				item.setQtdEstoque(rs.getInt(3));
				
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
					item = new Item();
					
					item.setIdItem(rs.getInt(1));
					item.setMarcaItem(rs.getString(2));
					item.setPrecoItem(rs.getDouble(4));
					item.setQtdEstoque(rs.getInt(3));
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
	
	public void adicionarProduto(Item item) {
		PreparedStatement ps;
		
		String sql = "insert into item (marca, qtdEstoque, preco, idTipo) values (?, ?, ?, ?)";
		try {
				ps = con.prepareStatement(sql);
				
				ps.setString(1, item.getMarcaItem());
				ps.setInt(2, item.getQtdEstoque());
				ps.setDouble(3, item.getPrecoItem());
				ps.setInt(4, item.getTipo().getIdTipo());
				
				ps.execute();
				ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public boolean removeItem(int codigoItem) {
		PreparedStatement ps;
		
		String sql = "delete from item where idItem = ?";
		try {
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, codigoItem);
				
				if(ps.executeUpdate() > 0) {
					return true;
				}
				else {
					return false;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
