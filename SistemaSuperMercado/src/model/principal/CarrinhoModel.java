package model.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.domain.Carrinho;
import model.domain.Item;
import model.dao.CarrinhoDAO;
import model.database.ConnectionFactory;
import model.domain.*;
public class CarrinhoModel {
	Item i;
	CarrinhoDAO dao = new CarrinhoDAO();
	public void adicionar(ObservableList<Item> item, Carrinho carrinho,int quantidade) {

		carrinho.setQtdItem(quantidade);
		carrinho.setItems(item.get(0));
		dao.carrinhoAdiciona(carrinho,item.get(0).getIdItem());
	}
	public void remover(int idItem) {
		CarrinhoDAO.carrinhoRemove(idItem);
	}
	public void limparCarrinho() {
		dao.limpaCarrinho();
	}
	public ArrayList<Integer> ids() {
		return dao.todosItems();
	}
	
}
