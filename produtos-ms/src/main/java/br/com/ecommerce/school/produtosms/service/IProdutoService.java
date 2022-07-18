package br.com.ecommerce.school.produtosms.service;

import br.com.ecommerce.school.produtosms.dto.QuantidadeDTO;

public interface IProdutoService {

    void processarEstoque(QuantidadeDTO quantidade, String codigo);
}
