package br.com.ecommerce.school.pedidosms.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutosDTO {

    private UUID codigo;
    private BigDecimal quantidade;

    public ProdutosDTO(UUID codigo, BigDecimal quantidade) {
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
