package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoProducer implements IPedidoProducer {

    private String criarPedido;

    private Producer<PedidoDTO> producerPedido;

    public PedidoProducer(@Value("${criar.pedido}") String criarPedido,
                          Producer<PedidoDTO> producerPedido) {
        this.criarPedido = criarPedido;
        this.producerPedido = producerPedido;
    }

    @Override
    public void enviarPedido(PedidoDTO pedidoDTO) {
        producerPedido.enviar(criarPedido, pedidoDTO);
    }
}
