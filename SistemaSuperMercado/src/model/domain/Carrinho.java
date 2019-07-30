package model.domain;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Carrinho {	
	ArrayList<Item> items;

	protected int qtdItem;
	
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(Item i) {
		items.add(i);
	}
	
	public int getQtdItem() {
		return qtdItem;
	}


	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}	

}