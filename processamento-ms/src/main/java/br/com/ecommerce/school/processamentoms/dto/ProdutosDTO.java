package br.com.ecommerce.school.processamentoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutosDTO {

    private UUID codigo;
    private BigDecimal quantidade;

    public ProdutosDTO(@JsonProperty("codigo") UUID codigo,
                       @JsonProperty("quantidade")BigDecimal quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
