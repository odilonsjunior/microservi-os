package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;

public interface IEnviarPedidoService {

    void enviarPedido(PedidoDTO pedidoDTO);
}
