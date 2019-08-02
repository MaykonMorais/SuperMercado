package model.principal;


import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import model.dao.ItemDAO;
import model.domain.Item;
import model.domain.Tipo;

public class GereciamentoProdutosModel {
	
	//lista todos os produtos
	public List<Item> listarItems() {
		ItemDAO items = new ItemDAO();
		
		return items.consultaTotal();
	}
	
	//adiciona produtos ao banco
	public void adicionar(String marca, Double preco, int qtd, Tipo tipo) {
		if(marca == null || preco < 0.0 || qtd < 0 || tipo == null) {
			JOptionPane.showMessageDialog(null, "Por favor, informe os dados corretamente!");
			
		}
		else {
			ItemDAO items = new ItemDAO();
			Item item = new Item();
			item.setMarcaItem(marca);
			item.setPrecoItem(preco);
			item.setQtdEstoque(qtd);
			item.setTipo(tipo);
			
			items.adicionarProduto(item);		
		}
	}
}
