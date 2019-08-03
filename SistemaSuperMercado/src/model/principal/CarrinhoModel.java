package model.principal;

import java.util.List;

import javafx.collections.ObservableList;
import model.domain.Carrinho;
import model.domain.Item;
import model.dao.CarrinhoDAO;
import model.domain.*;
public class CarrinhoModel {
	Item i;
	CarrinhoDAO dao = new CarrinhoDAO();
	public void adicionar(ObservableList<Item> item, Carrinho carrinho,int quantidade) {
	
		i = new Item(item.get(0).getIdItem(),item.get(0).getMarcaItem(),item.get(0).getQtdEstoque(),item.get(0).getPrecoItem());
		carrinho.setQtdItem(quantidade);
		carrinho.setItems(i);
		dao.carrinhoAdiciona(carrinho,item.get(0).getIdItem());
	}
	public void remover(int idItem) {
		dao.carrinhoRemove(idItem);
	}
}
