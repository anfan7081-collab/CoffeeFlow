package br.com.coffeeflow.model;

import java.math.BigDecimal;

public class ItemPedido {
    private int idItem;
    private int idPedido;
    private int idProduto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemPedido() {}
    public ItemPedido(int idItem, int idPedido, int idProduto, int quantidade, BigDecimal subtotal) {
        this.idItem = idItem; this.idPedido = idPedido; this.idProduto = idProduto;
        this.quantidade = quantidade; this.subtotal = subtotal;
    }
    public int getIdItem() { return idItem; }
    public void setIdItem(int id) { this.idItem = id; }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int id) { this.idPedido = id; }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int id) { this.idProduto = id; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
