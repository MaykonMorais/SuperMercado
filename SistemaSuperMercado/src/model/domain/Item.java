package model.domain;

public class Item {
    private int idItem;
    private String marcaItem;
    private double precoItem;
    private String nomeItem;

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

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

}