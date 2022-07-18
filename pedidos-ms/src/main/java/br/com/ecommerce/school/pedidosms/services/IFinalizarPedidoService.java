package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoFinalizadoDTO;

public interface IFinalizarPedidoService {
    void finalizarPedido(final PedidoFinalizadoDTO pedidoDTO);
}
