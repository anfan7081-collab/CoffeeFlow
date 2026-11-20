package br.com.coffeeflow.model;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String cargo;
    private int nivelAcesso;

    public Funcionario() {}
    public Funcionario(int idFuncionario, String nome, String cargo, int nivelAcesso) {
        this.idFuncionario = idFuncionario; this.nome = nome;
        this.cargo = cargo; this.nivelAcesso = nivelAcesso;
    }
    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int id) { this.idFuncionario = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public int getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(int nivelAcesso) { this.nivelAcesso = nivelAcesso; }
}
