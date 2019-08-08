package model.domain;

public class Item {
    private int idItem;
    private String marcaItem;
    private int qtdEstoque;
    private double precoItem;
    private Tipo tipo;
    
    public Item() {}
    
    public Item(int idItem) {
    	setIdItem(idItem);
    }
    
	public Item(String marcaItem, int qtdEstoque, double precoItem, Tipo tipo) {
		this.marcaItem = marcaItem;
		this.qtdEstoque = qtdEstoque;
		this.precoItem = precoItem;
		setTipo(tipo);
		
	}
	
	public Item(int idItem,String marcaItem, int qtdEstoque, double precoItem, Tipo tipo) {
		
		setIdItem(idItem);
		setMarcaItem(marcaItem);
		setQtdEstoque(qtdEstoque);
		setPrecoItem(precoItem);
		setTipo(tipo);
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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