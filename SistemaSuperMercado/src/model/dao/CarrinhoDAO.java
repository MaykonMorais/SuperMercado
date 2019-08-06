// camada de persistencia (Cuidado!)

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionFactory;
import model.domain.Carrinho;
import model.domain.Item;
import model.domain.Carrinho;
public class CarrinhoDAO {
	//gerente
	public void carrinhoAdiciona(Carrinho carrinho,int idItem) {

		Connection connect = ConnectionFactory.getConnection();
		String sql = "insert into Carrinho values(?,?);";
		
		try {
			PreparedStatement prepara = connect.prepareStatement(sql);
			
			prepara.setInt(1, idItem);
			prepara.setInt(2, carrinho.getQtdItem());
			
			prepara.execute();
			prepara.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void carrinhoRemove(int i) {
		Connection connect = ConnectionFactory.getConnection();
		String sql="delete from Carrinho where idItem = ? ;";
		try {
			PreparedStatement prepara = connect.prepareStatement(sql);
			prepara.setInt(1,i);
			prepara.execute();
			prepara.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpaCarrinho() {
		Connection connect = ConnectionFactory.getConnection();
		String id="select idItem from carrinho;";
		try {
			PreparedStatement pedeIdItem = connect.prepareStatement(id);
			ResultSet recebeIdItem = pedeIdItem.executeQuery();
			while(recebeIdItem.next()) {
				carrinhoRemove(recebeIdItem.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObservableList<Item> itemProcura(String marcaItem) {
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
	public ArrayList<Integer> todosItems(){
		Connection connect = ConnectionFactory.getConnection();
		String sql="select idItem from carrinho";
		ArrayList<Integer> numeros = new ArrayList<>();
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				numeros.add(rs.getInt(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return numeros;
	}
}