package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.config.WebClientConfig;
import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    private final WebClient webClient;

    private String uri;

    public ProdutoRepository(@Qualifier(WebClientConfig.BEAN_PRODUTO) WebClient webClient,  @Value("${uri.buscar.produto}")String uri) {
        this.webClient = webClient;
        this.uri = uri;
    }

    @Override
    public Optional<ProdutoDTO> buscar(ItemPedidoDTO produto) {
        Optional<ResponseEntity<ProdutoDTO>> responseEntity =
                Optional.ofNullable(webClient.get()
                        .uri(uriBuilder -> uriBuilder.path(uri).build(produto.getCodigo()))
                        .retrieve()
                        .toEntity(ProdutoDTO.class)
                        .block());

        return responseEntity.map(HttpEntity::getBody);
    }
}
