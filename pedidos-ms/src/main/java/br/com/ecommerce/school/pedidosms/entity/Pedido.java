package br.com.ecommerce.school.pedidosms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Pedido {

    @Id
    private String codigo = UUID.randomUUID().toString();

    private String cliente;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Produto> produtos;

    public Pedido(String codigo, String cliente, List<Produto> produtos) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
