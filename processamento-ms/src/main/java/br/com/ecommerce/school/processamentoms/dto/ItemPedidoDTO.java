package br.com.ecommerce.school.processamentoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemPedidoDTO {

    private String codigo;
    private BigDecimal quantidade;

    public ItemPedidoDTO(@JsonProperty("codigo") String codigo,
                         @JsonProperty("quantidade")BigDecimal quantidade) {
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
