package model.domain;

import java.util.Date;
import java.util.List;

public class Historico {
    private String codigoVenda;
    private int idItem;
    private String dataCompra;
    private List<Item> itens;
    
    private Item item;
    public Historico(String dataCompra) {
    	setDataCompra(dataCompra);
    }
   
    	
	/*
	public Historico1(String codigoVenda) {
		setCodigoVenda(codigoVenda);
	}
	*/
	
	public List<Item> getItens() {
		return itens;
	}
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public void setItens(List<Item> itens) {
		this.itens = itens;
	}


	public Historico(String codigoVenda,int idItem,String dataCompra,String marcaItem,int qtdEstoque,double preco,int idTipo,String nomeTipo,String formavenda) {
    	setCodigoVenda(codigoVenda);
    	setIdItem(idItem);
    	setDataCompra(dataCompra);
    	item = new Item(idItem,marcaItem,qtdEstoque,preco,idTipo,nomeTipo,formavenda);// setando o item
    	setItem(item);
    }
    
	public Historico(String codigoVenda,int idItem,String dataCompra) {
		setCodigoVenda(codigoVenda);
		setIdItem(idItem);
		setDataCompra(dataCompra);
	}
	
    public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
    public String getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(String codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	private int qtdPorItem;
    

	public int getQtdPorItem() {
		return qtdPorItem;
	}
	
	public void setQtdPorItem(int qtdPorItem) {
		this.qtdPorItem = qtdPorItem;
	}
	
	// metidas paleativas
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
}