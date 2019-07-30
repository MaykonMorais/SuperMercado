package model.domain;

public class Gerente extends Funcionario { // integridade de dados
	private String senhaGerente;

	// gerente vai usar um método autenticar no sistema (interface) 
    public Gerente(int idFuncionario, String nomeUsuario, String senhaGerente) {
    	
    }
	
	public String getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(String senhaGerente) {
        this.senhaGerente = senhaGerente;
    }
    
}	