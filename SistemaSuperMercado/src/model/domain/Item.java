package model.domain;

public class Item {
    private int idItem;
    private String marcaItem;
    private int qtdEstoque;
    private double precoItem;
    private double valorTotal; // temporario ate saber como passar um method
	private Tipo tipo;
    
    public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getValorTotal() {
		return valorTotal;
	}
    
	public void setValorTotal(int qtdEstoque,double precoItem) {
		this.valorTotal = qtdEstoque * precoItem;
	}

	public Item(int idItem,String marcaItem,int qtdEstoque,double precoItem) {
    	setIdItem(idItem);
    	setMarcaItem(marcaItem);
    	setQtdEstoque(qtdEstoque);
    	setPrecoItem(precoItem);
    	setValorTotal(getQtdEstoque(),getPrecoItem());
    }
	
	public Item(int idItem,String marcaItem,int qtdEstoque,double precoItem,int idTipo,String nomeTipo,String formavenda) {
    	setIdItem(idItem);
    	setMarcaItem(marcaItem);
    	setQtdEstoque(qtdEstoque);
    	setPrecoItem(precoItem);
    	setValorTotal(getQtdEstoque(),getPrecoItem());
    	tipo = new Tipo(idTipo,nomeTipo,formavenda);
    	setTipo(tipo);
    }
	

	public int getIdItem() {
        return idItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public String getMarcaItem() {
        return marcaItem;
    }

    public void setMarcaItem(String marcaItem) {
        this.marcaItem = marcaItem;
    }

    
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}


}