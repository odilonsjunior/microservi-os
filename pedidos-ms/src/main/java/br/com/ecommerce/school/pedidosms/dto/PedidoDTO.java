package br.com.ecommerce.school.pedidosms.dto;

import br.com.ecommerce.school.pedidosms.entity.EStatusPedido;

import java.util.List;

public class PedidoDTO {

    private String codigo;
    private String cliente;
    private List<ItemPedidoDTO> produtos;
    private EStatusPedido status;

    public PedidoDTO(String codigo, String cliente, List<ItemPedidoDTO> produtos, EStatusPedido status) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = status;
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedidoDTO> getProdutos() {
        return produtos;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(List<ItemPedidoDTO> produtos) {
        this.produtos = produtos;
    }

    public EStatusPedido getStatus() {
        return status;
    }

    public void setStatus(EStatusPedido status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void addCodigoGerado(String codigo){
        this.codigo = codigo;

    }
}
