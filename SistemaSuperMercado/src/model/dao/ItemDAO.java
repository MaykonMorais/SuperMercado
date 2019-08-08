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
import model.domain.Tipo;

public class ItemDAO {
	private Connection con;
	public ItemDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	Tipo tipo;
	public List<Item> consultaTotal(Item item) {
		PreparedStatement ps;
		ResultSet rs;
		
		List<Item> items = new ArrayList<Item>();
		
		try {
			ps = con.prepareStatement("select * from item inner join tipo on tipo.idTipo = item.idTipo ");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				item.setIdItem(rs.getInt(1));
				item.setMarcaItem(rs.getString(2));
				item.setPrecoItem(rs.getDouble(4));
				item.setValorTotal(item.getQtdEstoque(), item.getPrecoItem());
				tipo = new Tipo(rs.getInt(5),rs.getString(7),rs.getString(8));
				items.add(item);
				
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public ObservableList<Item> itemProcuraEstoque(Item item) {
		Connection con = ConnectionFactory.getConnection();
		
		ObservableList<Item> items = FXCollections.observableArrayList();

		String sql = "select * from item where marca like'%"+item.getMarcaItem()+"%'or idItem = "+item.getIdItem();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
					if(rs.getString(2).equals(item.getMarcaItem()) || rs.getInt(1) ==item.getIdItem()){ 
					item = new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));

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
	

	public Item itemProcura(Item item) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select * from item inner join tipo on tipo.idTipo = item.idTipo where marca = (?) ;";

		try {
			PreparedStatement ps;
			ResultSet	 rs ;	
				ps = con.prepareStatement(sql);
				ps.setString(1, item.getMarcaItem());
				//ps.setInt(2,Integer.parseInt(item.getMarcaItem()));
				rs = ps.executeQuery();
			while(rs.next()) {
				item.setIdItem(rs.getInt(1));
				item.setMarcaItem(rs.getString(2));
				item.setPrecoItem(rs.getDouble(4));
				item.setValorTotal(item.getQtdEstoque(), item.getPrecoItem());
				tipo = new Tipo(rs.getInt(5),rs.getString(7),rs.getString(8));
				item.setTipo(tipo);
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
}
