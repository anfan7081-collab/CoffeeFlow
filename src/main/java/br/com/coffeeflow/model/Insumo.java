package br.com.coffeeflow.model;

public class Insumo {
    private int idInsumo;
    private String nome;
    private int quantidadeEstoque;

    public Insumo() {}
    public Insumo(int idInsumo, String nome, int quantidadeEstoque) {
        this.idInsumo = idInsumo; this.nome = nome; this.quantidadeEstoque = quantidadeEstoque;
    }
    public int getIdInsumo() { return idInsumo; }
    public void setIdInsumo(int id) { this.idInsumo = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidade) { this.quantidadeEstoque = quantidade; }
}
