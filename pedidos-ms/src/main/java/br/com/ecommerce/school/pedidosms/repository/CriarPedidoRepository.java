package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CriarPedidoRepository implements ICriarPedidoRepository {

    private String criarPedido;

    private Producer<PedidoDTO> producerPedido;

    public CriarPedidoRepository(@Value("${criar.pedido}") String criarPedido,
                                 Producer<PedidoDTO> producerPedido) {
        this.criarPedido = criarPedido;
        this.producerPedido = producerPedido;
    }

    @Override
    public void criarPedido(PedidoDTO pedidoDTO) {
        producerPedido.enviar(criarPedido, pedidoDTO);
    }
}
