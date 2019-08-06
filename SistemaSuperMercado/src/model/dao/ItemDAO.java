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
	Item item = null;
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
				 item = new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
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
	
	public ObservableList<Item> itemProcuraEstoque(String marcaItem) {
		Connection con = ConnectionFactory.getConnection();
		Item item = null;
		
		ObservableList<Item> items = FXCollections.observableArrayList();

		String sql = "select * from item where marca like'%"+marcaItem+"%'or idItem = "+Integer.parseInt(marcaItem);
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
					if(rs.getString(2).equals(marcaItem) || rs.getInt(1) ==Integer.parseInt(marcaItem)){ 
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
	

	public ObservableList<Item> itemProcura(String marcaItem,int quantidade) {
		Connection con = ConnectionFactory.getConnection();
		ObservableList<Item> items = FXCollections.observableArrayList();

		String sql = "select * from item inner join tipo on tipo.idTipo = item.idTipo ;";
		
		try {
			PreparedStatement ps;
			ResultSet	 rs ;	
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
			
			while(rs.next()) {
					if(rs.getInt(1) ==Integer.parseInt(marcaItem) ) {
						item = new Item(rs.getInt(1),rs.getString(2),quantidade,rs.getDouble(4),rs.getInt(5),rs.getString(7),rs.getString(8));
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
		
		String sql = "insert into item values (?, ?, ?, ?)";
		try {
				ps = con.prepareStatement(sql);
				
				ps.setString(1, item.getMarcaItem());
				ps.setInt(2, item.getQtdEstoque());
				ps.setDouble(3, item.getPrecoItem());
				//ps.setInt(4, item.getTipo().getIdTipo());
				
				ps.execute();
				ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int quantidade() {
		return item.getQtdEstoque();
	}
	 public  boolean verificaNumero(String texto) {
	        if(texto == null) {
	            return false;
	        }
	        for (char letra : texto.toCharArray()) {
	            if(letra < '0' || letra > '9') {
	                return false;
	                }
	        }
	        return true;
	    }
}
