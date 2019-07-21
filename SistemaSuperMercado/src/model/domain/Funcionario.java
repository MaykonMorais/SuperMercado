package model.domain;

public abstract class Funcionario {
    protected int idFuncionario;
    protected String nomeFuncionario;

    public abstract int getIdFuncionario();
    public abstract void setIdFuncinario(int id);
    public abstract String getNomeFuncionario();
    public abstract void setNomeFuncionario(String nome);
}