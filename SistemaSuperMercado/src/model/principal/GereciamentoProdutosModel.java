package model.principal;


import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import model.dao.ItemDAO;
import model.domain.Item;

public class GereciamentoProdutosModel {
	
	public List<Item> listarItems() {
		ItemDAO items = new ItemDAO();
		
		return items.consultaTotal();
	}
	public List<Item> adicionar(String marca, Double preco, int qtd, int tipo) {
		if(marca == null || preco < 0.0 || qtd < 0 || tipo < 0) {
			JOptionPane.showMessageDialog(null, "Por favor, informe os dados corretamente!");
			return null;
		}
		else {
			ItemDAO items = new ItemDAO();
			
		}
	}
}
