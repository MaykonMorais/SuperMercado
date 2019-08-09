package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionFactory;
import model.domain.Item;
import model.domain.Tipo;

public class ItemDAO {
	private static Connection con;
	Tipo tipo;
	
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
	
	public ObservableList<Item> itemProcura(String marcaItem) { // atualizar 
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
	
	public Item procuraItemId(Item item) {
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "select * from item where idItem = " + item.getIdItem();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				
				item.setIdItem(rs.getInt(1));
				item.setMarcaItem(rs.getString(2));
				item.setPrecoItem(rs.getDouble(4));
				item.setQtdEstoque(rs.getInt(3));
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		return item;
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
	
	public int removeItem(Item item) {
		int linhasAfetadas = 0;
		PreparedStatement ps;
		
		String sql = "delete from item where idItem = ?";
		try {
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, item.getIdItem());
				
				linhasAfetadas = ps.executeUpdate();
		
								
		} catch (SQLException  e) {
			e.printStackTrace();
			
		}
		return linhasAfetadas;
	}
	public void atualizarItem(Item item) {
		PreparedStatement ps;
		
		String sql = "update item set marca = ?, qtdestoque = ?, preco = ?, idTipo = ? where idItem = ?";
		try {
				ps = con.prepareStatement(sql);
				
				ps.setString(1, item.getMarcaItem());
				ps.setInt(2, item.getQtdEstoque());
				ps.setDouble(3, item.getPrecoItem());
				ps.setInt(4, item.getTipo().getIdTipo());
				
				ps.setInt(5, item.getIdItem());
				
				ps.execute();
				ps.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				if(rs.getInt(3)>=item.getQtdEstoque()) {
					item.setIdItem(rs.getInt(1));
					item.setMarcaItem(rs.getString(2));
					item.setPrecoItem(rs.getDouble(4));
					item.setValorTotal(item.getQtdEstoque(), item.getPrecoItem());
					tipo = new Tipo(rs.getInt(5),rs.getString(7),rs.getString(8));
					item.setTipo(tipo);
				}else {
				JOptionPane.showMessageDialog(null, "Quantidade exigida maior do que o estoque");
				item = null ;
			}
			rs.close();
			ps.close();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
}
