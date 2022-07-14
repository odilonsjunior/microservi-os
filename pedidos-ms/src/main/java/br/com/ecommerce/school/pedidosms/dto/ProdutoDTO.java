package br.com.ecommerce.school.pedidosms.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String codigo;
    private BigDecimal quantidade;

    public ProdutoDTO(String codigo, BigDecimal quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
