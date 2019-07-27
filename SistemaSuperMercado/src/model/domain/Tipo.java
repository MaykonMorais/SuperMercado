package model.domain;

public class Tipo {
	private int idTipo;
	private String nomeTipo;
	private String formaVenda;
	
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	public String getFormaVenda() {
		return formaVenda;
	}
	public void setFormaVenda(String formaVenda) {
		this.formaVenda = formaVenda;
	}
}