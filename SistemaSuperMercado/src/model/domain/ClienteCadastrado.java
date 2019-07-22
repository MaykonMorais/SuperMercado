package model.domain;

public class ClienteCadastrado extends Cliente {
	private int cpf;
	private String senha; // senha deve ser criptografada 
	
	// usar construtor
	public ClienteCadastrado(int idCliente) {
		super(idCliente);
		
	}
		
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) { // criptografar senha
		this.senha = senha;
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) { // autenticar cpf
		this.cpf = cpf;
	}
}
