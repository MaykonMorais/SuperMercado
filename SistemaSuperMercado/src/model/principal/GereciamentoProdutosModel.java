package model.principal;


import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.ItemDAO;
import model.domain.Item;
import model.domain.Tipo;

public class GereciamentoProdutosModel {
	ItemDAO i = new ItemDAO();
	
	//lista todos os produtos
	public List<Item> listarItems(Item item) {
		ItemDAO items = new ItemDAO();
		
		return items.consultaTotal(item);
	}
	
	//adiciona produtos ao banco
	public void adicionar(String marca, Double preco, int qtd, Tipo tipo) {
		if(marca == null || preco < 0.0 || qtd < 0 || tipo == null) {
			JOptionPane.showMessageDialog(null, "Por favor, informe os dados corretamente");
			
		}
		else {		
		}
	}
	public ObservableList<Item> procura(Item item){
		ObservableList<Item> items = FXCollections.observableArrayList();
		items.add(i.itemProcura(item));
		return items ; 
	}
	
}
