package br.com.coffeeflow.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private LocalDateTime dataPedido;
    private int idFuncionario;
    private BigDecimal valorTotal;

    public Pedido() {}
    public Pedido(int idPedido, LocalDateTime dataPedido, int idFuncionario, BigDecimal valorTotal) {
        this.idPedido = idPedido; this.dataPedido = dataPedido;
        this.idFuncionario = idFuncionario; this.valorTotal = valorTotal;
    }
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int id) { this.idPedido = id; }
    public LocalDateTime getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDateTime data) { this.dataPedido = data; }
    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int id) { this.idFuncionario = id; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valor) { this.valorTotal = valor; }
}
