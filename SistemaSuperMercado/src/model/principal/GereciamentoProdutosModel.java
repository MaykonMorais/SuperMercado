package model.principal;

import java.util.List;

import javax.swing.JOptionPane;

import beans.Item;
import beans.Tipo;
import dao.ItemDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GereciamentoProdutosModel {
	ItemDAO items = new ItemDAO();
	Item item;
	
	//lista todos os produtos
	public List<Item> listarItems() {
		ItemDAO items = new ItemDAO();
		
		return items.consultaTotal();
	}
	
	public void adicionar(Item item) throws Exception {
		if(item.getMarcaItem().isEmpty() || item.getPrecoItem() < 0 || item.getQtdEstoque() < 0) {
			 throw new Exception();
		}
		else {
			items.adicionarProduto(item);
		}
	}
	
	public List<Item> procuraItem(String marca) { // ajeitar
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
	
	public void removerItem (Item item) throws Exception {
		if(items.removeItem(item) != 0) {
			JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
		}
		else {
			throw new Exception();
		}
	}
	
	public Item procuraItem(Item i) throws NullPointerException { // revisar parte
		item =  items.procuraItemId(i);
		if(item.getPrecoItem() != 0) { // 
			return item;
		}
		else {
			throw new NullPointerException();
		}
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