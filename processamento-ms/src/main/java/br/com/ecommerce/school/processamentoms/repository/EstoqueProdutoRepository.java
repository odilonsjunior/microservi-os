package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.config.custom.WebClientCustomBuilder;
import br.com.ecommerce.school.processamentoms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.processamentoms.dto.QuantidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class EstoqueProdutoRepository implements IEstoquePedidoRepository {

    @Value("${uri.pedidos.estoque}")
    private String uri;

    @Value("${url.server.produtos}")
    private String url;

    @Autowired
    @Qualifier("webClientBuilder")
    private WebClient.Builder builder;

    @Override
    public void executarBaixa(ItemPedidoDTO produto) {

        final QuantidadeDTO body = new QuantidadeDTO(produto.getQuantidade());

        new WebClientCustomBuilder<String>(builder)
                .withBaseUrlAndUri(url, uri)
                .withPut()
                .withPathParam("idproduto", produto.getCodigo())
                .withBody(body)
                .build();
    }
}
