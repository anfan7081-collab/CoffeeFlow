package br.com.coffeeflow.dao;

import br.com.coffeeflow.config.Conexao;
import br.com.coffeeflow.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void cadastrar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco_unitario) VALUES (?, ?)";
        try (Connection con = Conexao.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setBigDecimal(2, produto.getPrecoUnitario());
            ps.executeUpdate();
        }
    }

    public List<Produto> listarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id_produto, nome, preco_unitario FROM produtos ORDER BY nome";
        try (Connection con = Conexao.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                produtos.add(new Produto(rs.getInt("id_produto"),
                    rs.getString("nome"), rs.getBigDecimal("preco_unitario")));
            }
        }
        return produtos;
    }
}
