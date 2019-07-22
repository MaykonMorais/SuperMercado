package model.domain;

public class Gerente extends Funcionario { // integridade de dados
    private String nomeUsuario;
	private String senhaGerente;

	// gerente vai usar um método autenticar no sistema (interface) 
    public Gerente(int idFuncionario, String nomeUsuario, String senhaGerente) {
    	
    }
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(String senhaGerente) {
        this.senhaGerente = senhaGerente;
    }
    
}	