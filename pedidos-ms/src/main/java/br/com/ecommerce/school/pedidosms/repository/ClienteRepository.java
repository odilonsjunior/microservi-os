package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.config.custom.WebClientCustomBuilder;
import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Repository
public class ClienteRepository implements IClienteRepository {

    @Value("${uri.buscar.cliente}")
    private String uri;

    @Value("${url.server.cliente}")
    private String url;

    @Autowired
    @Qualifier("webClientBuilder")
    private WebClient.Builder builder;

    @Override
    public Optional<ClienteDTO> buscar(String cliente) {

        final ResponseEntity<ClienteDTO> responseEntity = new WebClientCustomBuilder<ClienteDTO>(builder)
                .withBaseUrlAndUri(url, uri)
                .withGet()
                .withPathParam("cliente", cliente)
                .withToResponseEntity(ClienteDTO.class)
                .build();

        return Optional.ofNullable(responseEntity.getBody());
    }
}
