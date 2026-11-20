package br.com.coffeeflow.model;

import java.math.BigDecimal;

public class Produto {
    private int idProduto;
    private String nome;
    private BigDecimal precoUnitario;

    public Produto() {}
    public Produto(String nome, BigDecimal precoUnitario) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }
    public Produto(int idProduto, String nome, BigDecimal precoUnitario) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
    @Override public String toString() {
        return idProduto + " - " + nome + " | R$ " + precoUnitario;
    }
}
