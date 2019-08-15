package beans;

public abstract class Cliente{
	protected int idCliente;

	public Cliente (int idCliente) {
		setIdCliente(idCliente);
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
