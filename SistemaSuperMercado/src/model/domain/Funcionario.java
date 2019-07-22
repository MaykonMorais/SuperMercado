package model.domain;

//garantir integridade
public class Funcionario { // funcionario deve ser instanciado
    protected int idFuncionario;
    protected String nomeFuncionario;
	
    
    public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

   
}