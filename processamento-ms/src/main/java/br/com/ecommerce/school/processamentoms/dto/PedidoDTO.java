package br.com.ecommerce.school.processamentoms.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class PedidoDTO implements Serializable {

    private UUID cliente;
    private List<ProdutosDTO> produtos;

    public PedidoDTO(UUID cliente, List<ProdutosDTO> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public UUID getCliente() {
        return cliente;
    }

    public List<ProdutosDTO> getProdutos() {
        return produtos;
    }
}
