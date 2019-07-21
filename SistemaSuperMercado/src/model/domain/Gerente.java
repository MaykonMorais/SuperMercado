package model.domain;

public class Gerente extends Funcionario { // integridade de dados
    private String nomeUsuario;
	private String senhaGerente;

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
    
    @Override
    public int getIdFuncionario(){
        return idFuncionario;
    }
    
    @Override
    public void setIdFuncinario(int id){
        this.idFuncionario = id;
    }
    @Override
    public String getNomeFuncionario(){
        return nomeFuncionario;
    }
    @Override
    public  void setNomeFuncionario(String nome){
        this.nomeFuncionario = nome;
    }
}