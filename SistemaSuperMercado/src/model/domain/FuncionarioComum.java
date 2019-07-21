package model.domain;

public class FuncionarioComum extends Funcionario {

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