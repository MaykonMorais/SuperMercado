package beans;

public class Gerente extends Funcionario { // integridade de dados
	private String senhaGerente;

	// gerente vai usar um método autenticar no sistema (interface) 
    public Gerente(String nome, int idFuncionario, String senhaFuncionario) {
    	super(nome, idFuncionario, senhaFuncionario);
    	
    }
	
	public String getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(String senhaGerente) {
        this.senhaGerente = senhaGerente;
    }
    
}	