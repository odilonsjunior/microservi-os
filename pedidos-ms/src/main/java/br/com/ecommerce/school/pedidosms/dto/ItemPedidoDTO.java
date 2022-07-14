package br.com.ecommerce.school.pedidosms.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {

    private String produto;
    private BigDecimal quantidade;

    public ItemPedidoDTO(String codigo, BigDecimal quantidade) {
        this.produto = codigo;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedidoDTO{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
