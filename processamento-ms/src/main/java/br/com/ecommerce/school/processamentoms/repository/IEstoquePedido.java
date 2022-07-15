package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.ProdutosDTO;

import java.util.List;

public interface IEstoquePedido {

    void executarBaixa(List<ProdutosDTO> produtos);
}
