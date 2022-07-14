package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;

public interface IPedidoProducer {

    void enviarPedido(PedidoDTO pedidoDTO);

}
