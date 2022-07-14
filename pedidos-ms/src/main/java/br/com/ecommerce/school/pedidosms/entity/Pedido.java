package br.com.ecommerce.school.pedidosms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private String codigo = UUID.randomUUID().toString();

    @Enumerated(value = EnumType.STRING)
    private EStatusPedido status;

    private String cliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_pedido")
    private List<ItemPedido> items;

    public Pedido() {
    }

    public Pedido(String codigo, EStatusPedido status, String cliente, List<ItemPedido> produtos) {
        this.codigo = codigo;
        this.status = status;
        this.cliente = cliente;
        this.items = produtos;
    }

    public Pedido(EStatusPedido status, String cliente, List<ItemPedido> produtos) {
        this.status = status;
        this.cliente = cliente;
        this.items = produtos;
    }

    public String getCodigo() {
        return codigo;
    }

    public EStatusPedido getStatus() {
        return status;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setStatus(EStatusPedido status) {
        this.status = status;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }
}
