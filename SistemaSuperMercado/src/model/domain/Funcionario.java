package model.domain;

public abstract class Funcionario { // funcionario deve ser instanciado
    protected int idFuncionario;
    protected String nomeFuncionario;

    public abstract int getIdFuncionario();
    public abstract void setIdFuncinario(int id);
    public abstract String getNomeFuncionario();
    public abstract void setNomeFuncionario(String nome);
}