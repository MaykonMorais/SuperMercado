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
	public void adicionar(Item item, Carrinho carrinho) {

		carrinho.setItems(item);
		dao.carrinhoAdiciona(carrinho,item);
	}
	public void remover(Item item) {
		CarrinhoDAO.carrinhoRemove(item);
	}
	public void limparCarrinho() {
		dao.limpaCarrinho();
	}
	public ArrayList<Integer> ids() {
		return dao.todosItems();
	}
	
}
