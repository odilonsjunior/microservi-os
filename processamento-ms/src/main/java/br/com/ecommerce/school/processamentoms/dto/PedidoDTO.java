package br.com.ecommerce.school.processamentoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class PedidoDTO implements Serializable {

    private UUID cliente;
    private List<ItemPedidoDTO> produtos;

    public PedidoDTO(@JsonProperty("cliente") UUID cliente,
                     @JsonProperty("produtos")List<ItemPedidoDTO> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public UUID getCliente() {
        return cliente;
    }

    public List<ItemPedidoDTO> getProdutos() {
        return produtos;
    }


    @Override
    public String toString() {
        return "PedidoDTO{" +
                "cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
