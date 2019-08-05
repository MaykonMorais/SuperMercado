package model.principal;

import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import model.dao.ItemDAO;
import model.domain.Item;
import model.domain.Tipo;

public class GereciamentoProdutosModel {
	ItemDAO items = new ItemDAO();
	
	//lista todos os produtos
	public List<Item> listarItems() {
		ItemDAO items = new ItemDAO();
		
		return items.consultaTotal();
	}
	
	//adiciona produtos ao banco
	public void adicionar(String marca, Double preco, int qtd, Tipo tipo) {
		if(marca.isEmpty() || (preco.isNaN() || preco < 0) || qtd < 0 || tipo == null) {
			JOptionPane.showMessageDialog(null, "Por favor, informe os dados corretamente!");
			
		}
		else {
			
			Item item = new Item();
			item.setMarcaItem(marca);
			item.setPrecoItem(preco);
			item.setQtdEstoque(qtd);
			item.setTipo(tipo);
			
			items.adicionarProduto(item);		
		}
	}
	
	public List<Item> procuraItem(String marca) {
		if(marca.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite um campo válido");
			return null;
		}
		else {
			if(items.itemProcura(marca) !=  null) {
				return (List) items.itemProcura(marca);
			}
			else {
				JOptionPane.showConfirmDialog(null, "Item não encontrado");
				return null;
			}
		}
	}
	
	public boolean removerItem(int idItem) {
		boolean pass = items.removeItem(idItem);
		
		return pass;
	}
}