package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.config.WebClientConfig;
import br.com.ecommerce.school.processamentoms.dto.ItemPedidoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class EstoqueProdutoRepository implements IEstoquePedidoRepository {

    private final WebClient webClient;

    @Value("${uri.pedidos.estoque}")
    private String uri;


    public EstoqueProdutoRepository(@Qualifier(WebClientConfig.BEAN_PRODUTOS) WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public void executarBaixa(ItemPedidoDTO produto) {

        final String uriProduto = uri.replace("{idproduto}", produto.getCodigo());

        webClient.put().uri(uriProduto, produto.getCodigo())
                .body(BodyInserters.fromValue(produto))
                .retrieve()
                .toEntity(String.class)
                .block();

    }
}
