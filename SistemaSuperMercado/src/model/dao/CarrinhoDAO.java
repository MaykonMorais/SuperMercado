// camada de persistencia (Cuidado!)

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
}