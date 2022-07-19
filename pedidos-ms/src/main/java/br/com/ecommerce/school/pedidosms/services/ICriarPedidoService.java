package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoCriadoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;

public interface ICriarPedidoService {

    PedidoCriadoDTO criar(PedidoDTO pedidoDTO);
}
