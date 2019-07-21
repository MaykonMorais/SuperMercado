package model.domain;

public class Gerente extends Funcionario {
    private String senhaGerente;

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