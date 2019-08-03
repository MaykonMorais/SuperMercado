package model.domain;

public class Tipo {
	private int idTipo;
	private String nomeTipo;
	private String formaVenda;
	
	
	public Tipo() {}
	
	public Tipo(int codigoTipo,String nomeTipo,String UnidadeMedida) {
		setIdTipo(codigoTipo);
		setNomeTipo(nomeTipo);
		setFormaVenda(UnidadeMedida);
	}
	
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
	
	@Override
	public String toString() {
		return getNomeTipo();
	}
}