package br.com.ecommerce.school.pedidosms.helpers;

import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;
import br.com.ecommerce.school.pedidosms.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public final class ProdutoHelper {

    private ProdutoHelper() {
    }

    public static List<Produto> parseProdutosDto(List<Produto> produtos, List<ProdutoDTO> produtosDto) {
        if (produtos == null) return new ArrayList<>();
        produtosDto.forEach(dto ->
            produtos.add(new Produto(dto.getCodigo(), dto.getQuantidade())));

        return produtos;
    }

    public static List<Produto> parseProdutosDto(List<ProdutoDTO> produtosDto) {
        return parseProdutosDto(new ArrayList<>(), produtosDto);
    }
}
