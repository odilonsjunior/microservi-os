package br.com.ecommerce.school.pedidosms.helpers;

import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public final class ProdutoHelper {

    private ProdutoHelper() {
    }

    public static List<ItemPedido> parseProdutosDto(List<ItemPedido> produtos, List<ItemPedidoDTO> produtosDto) {
        if (produtos == null) return new ArrayList<>();
        produtosDto.forEach(dto ->
            produtos.add(new ItemPedido(dto.getProduto(), dto.getQuantidade())));
        return produtos;
    }

    public static List<ItemPedido> parseProdutosDto(List<ItemPedidoDTO> produtosDto) {
        return parseProdutosDto(new ArrayList<>(), produtosDto);
    }
}
