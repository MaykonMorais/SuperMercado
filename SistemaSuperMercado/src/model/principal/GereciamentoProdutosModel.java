package model.principal;

import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
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
	
	public void adicionar(Item item) {
		try {
			items.adicionarProduto(item);
			
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public boolean removerItem (Item item) throws Exception {
		
		boolean pass = items.removeItem(item);
		
		return pass;
	}
	
	public Item procuraItem(Item item) throws NullPointerException { // revisar parte
		return items.procuraItemId(item);
		
	}
	
	public void atualiza(Item item) {
		items.atualizarItem(item);
	}
	
	public ObservableList<Item> procura(Item item){
		ObservableList<Item> i = FXCollections.observableArrayList();
		i.add(items.itemProcura(item));
		return i; 
	}
}