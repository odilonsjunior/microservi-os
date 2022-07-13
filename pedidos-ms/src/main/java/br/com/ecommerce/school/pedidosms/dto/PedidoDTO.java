package br.com.ecommerce.school.pedidosms.dto;

import java.util.List;
import java.util.UUID;

public class PedidoDTO {

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
