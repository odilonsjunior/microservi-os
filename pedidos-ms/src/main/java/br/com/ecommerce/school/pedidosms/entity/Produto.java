package br.com.ecommerce.school.pedidosms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Produto {

    @Id
    private String codigo = UUID.randomUUID().toString();

    private Double quantidade;

    public Produto(String codigo, Double quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public Double getQuantidade() {
        return quantidade;
    }
}
