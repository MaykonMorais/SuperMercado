package model.principal;

import java.util.List;

import javafx.collections.ObservableList;
import model.domain.Carrinho;
import model.domain.Item;
import model.dao.CarrinhoDAO;
import model.domain.*;
public class CarrinhoModel {
	CarrinhoDAO dao = new CarrinhoDAO();
	public void adicionar(ObservableList<Item> item, Carrinho carrinho,int quantidade) {
		carrinho.setItems(item.get(0));
		carrinho.setQtdItem(quantidade);
		CarrinhoDAO dao = new CarrinhoDAO();
		dao.carrinhoAdiciona(carrinho,item.get(0).getIdItem());
	}
	public void remover(int idItem) {
		dao.carrinhoRemove(idItem);
	}
}
