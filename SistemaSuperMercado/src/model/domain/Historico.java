package model.domain;

import java.util.Date;

public class Historico {
    private int idCompra;
    private int idCaixa;
    private int qtdPorItem;
    private Date dataCompra;

    public int getIdCompra(){
        return idCompra;
    }
    public void setIdCompra(int id){
        this.idCompra = id;
    }
	public int getIdCaixa() {
		return idCaixa;
	}
	
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	
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