package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.ecommerce.school.pedidosms.config.WebClientConfig;

import java.util.Optional;

@Repository
public class ClienteRepository implements IClienteRepository {

    private final WebClient webClient;

    @Value("${uri.buscar.cliente}")
    private String uri;

    public ClienteRepository(@Qualifier(WebClientConfig.BEAN_CLIENTE) WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Optional<ClienteDTO> buscar(String cliente) {

        Optional<ResponseEntity<ClienteDTO>> responseEntity =
                Optional.ofNullable(webClient.get()
                        .uri(uriBuilder -> uriBuilder.path(uri).build(cliente))
                        .retrieve()
                        .toEntity(ClienteDTO.class)
                        .block());

        return responseEntity.map(HttpEntity::getBody);
    }
}
