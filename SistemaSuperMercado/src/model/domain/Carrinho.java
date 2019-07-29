package model.domain;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Carrinho {	
	ArrayList<Item> items;
	protected int idCarrinho;
	protected Cliente cliente;
	protected int qtdItem;
	
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	
	public int getQtdItem() {
		return qtdItem;
	}


	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}


	public int getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}