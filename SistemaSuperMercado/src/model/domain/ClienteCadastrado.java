package model.domain;

public class ClienteCadastrado extends Cliente {
	private int cpf;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String id) {
		this.idCliente = id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
}
