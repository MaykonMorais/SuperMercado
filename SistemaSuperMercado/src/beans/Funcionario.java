package beans;

//garantir integridade
public class Funcionario extends Pessoa { // funcionario deve ser instanciado
    private int idFuncionario;
    private String senha;
    
    public Funcionario(String nome, int idFuncionario, String senha) {
    	super(nome);
    	setIdFuncionario(idFuncionario);
    	setSenha(senha);
    }
    
    public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

   
}