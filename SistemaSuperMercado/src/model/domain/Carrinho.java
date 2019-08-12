package model.domain;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Carrinho {	
	ArrayList<Item> items = new ArrayList<>();
	
	protected double precoTotal;
	
	
	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(Item i) {
		items.add(i);
	}
	


}