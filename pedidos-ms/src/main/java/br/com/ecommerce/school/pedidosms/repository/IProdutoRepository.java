package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;

import java.util.Optional;

public interface IProdutoRepository {

    Optional<ProdutoDTO> buscar(ItemPedidoDTO produto);
}
