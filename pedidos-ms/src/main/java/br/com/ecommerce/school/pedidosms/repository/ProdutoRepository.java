package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.config.custom.WebClientCustomBuilder;
import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    @Value("${uri.buscar.produto}")
    private String uri;

    @Value("${url.server.produto}")
    private String url;

    @Autowired
    @Qualifier("webClientBuilder")
    private WebClient.Builder builder;

    @Override
    public Optional<ProdutoDTO> buscar(String produto) {

        final ResponseEntity<ProdutoDTO> responseEntity = new WebClientCustomBuilder<ProdutoDTO>(builder)
                .withBaseUrlAndUri(url, uri)
                .withGet()
                .withPathParam("produtos", produto)
                .withToResponseEntity(ProdutoDTO.class)
                .build();

        return Optional.ofNullable(responseEntity.getBody());
    }
}
