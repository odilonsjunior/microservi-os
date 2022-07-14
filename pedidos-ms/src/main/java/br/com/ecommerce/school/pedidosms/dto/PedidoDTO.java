package br.com.ecommerce.school.pedidosms.dto;

import br.com.ecommerce.school.pedidosms.entity.EStatusPedido;

import java.util.List;

public class PedidoDTO {

    private String cliente;
    private List<ProdutoDTO> produtos;
    private EStatusPedido status;

    public PedidoDTO(String cliente, List<ProdutoDTO> produtos, EStatusPedido status) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public EStatusPedido getStatus() {
        return status;
    }

    public void setStatus(EStatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
