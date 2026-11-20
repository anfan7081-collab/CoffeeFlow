package br.com.coffeeflow.model;

public class Receita {
    private int idProduto;
    private int idInsumo;
    private int quantidadeUtilizada;

    public Receita() {}
    public Receita(int idProduto, int idInsumo, int quantidadeUtilizada) {
        this.idProduto = idProduto; this.idInsumo = idInsumo;
        this.quantidadeUtilizada = quantidadeUtilizada;
    }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int id) { this.idProduto = id; }
    public int getIdInsumo() { return idInsumo; }
    public void setIdInsumo(int id) { this.idInsumo = id; }
    public int getQuantidadeUtilizada() { return quantidadeUtilizada; }
    public void setQuantidadeUtilizada(int quantidade) { this.quantidadeUtilizada = quantidade; }
}
