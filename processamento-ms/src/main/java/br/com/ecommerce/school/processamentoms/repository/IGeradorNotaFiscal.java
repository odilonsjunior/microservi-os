package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;

public interface IGeradorNotaFiscal {

    void gerar(PedidoDTO pedido);

}
