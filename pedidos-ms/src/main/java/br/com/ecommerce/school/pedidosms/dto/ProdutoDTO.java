package br.com.ecommerce.school.pedidosms.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String produto;
    private BigDecimal quantidade;

    public ProdutoDTO(String codigo, BigDecimal quantidade) {
        this.produto = codigo;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
