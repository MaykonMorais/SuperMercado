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

public class CarrinhoDAO {
	//gerente
	public void carrinhoAdiciona(Item item, Carrinho carrinho) {
		carrinho.getItems().add(item);
		
		Connection connect = ConnectionFactory.getConnection();
		String sql = "insert into Carrinho values(?,?);";
		
		try {
			PreparedStatement prepara = connect.prepareStatement(sql);
			
			prepara.setInt(1, item.getIdItem());
			prepara.setInt(2, carrinho.getQtdItem());
			
			prepara.execute();
			prepara.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//carrinho
		
	/*
	public static void carrinhoCompleto() {
		Connection connect = ConecaToBanco.getConnection();
		String sql="select T.nomeTipo,I.marca,I.preco from Carrinho as C full join Tipo as T on T.idTipo=C.idItem full join Item as I on I.idTipo = T.idTipo order by I.preco desc;";
		try {
			PreparedStatement prepara = connect.prepareStatement(sql);
			
			ResultSet verificaBD =prepara.executeQuery();
			System.out.println("\nNome.....Marca.....Preço");
			while(verificaBD.next()) {
				System.out.println("\n"+verificaBD.getString(1)+" ..... "+verificaBD.getString(2)+" ..... "+verificaBD.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("CarrinhoCompleto");
		}
	}
	
	public static void carrinhoRemove(int i) {
		Connection connect = ConecaToBanco.getConnection();
		String sql="delete from Carrinho where idCarrinho = "+i+";";
		try {
			PreparedStatement prepara = connect.prepareStatement(sql);
			prepara.execute();
			prepara.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Carrinhoremove");
		}
	}
	*/

}