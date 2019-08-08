package model.domain;

import java.util.Date;

public class Historico {
    private String codigoVenda;
    private int idItem;
    private Date dataCompra;
    private Item item;
    
    public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	public Historico(String codigoVenda) {
	setCodigoVenda(codigoVenda);
	}
	public Historico(String codigoVenda,int idItem,Date dataCompra,String marcaItem,int qtdEstoque,double preco,int idTipo,String nomeTipo,String formavenda) {
    	setCodigoVenda(codigoVenda);
    	setIdItem(idItem);
    	setDataCompra(dataCompra);
    	item = new Item(idItem,marcaItem,qtdEstoque,preco,idTipo,nomeTipo,formavenda);// setando o item
    	setItem(item);
    }
    
	public Historico(String codigoVenda,int idItem,Date dataCompra) {
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
	
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
}