package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class GeradorNotaFiscal implements IGeradorNotaFiscal {

    private final WebClient webClient;

    @Value("${uri.emissao.nf}")
    private String uri;

    public GeradorNotaFiscal(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public void gerar(PedidoDTO pedido) {
        webClient.post().uri(uri)
                .body(BodyInserters.fromValue(pedido))
                .retrieve()
                .toEntity(String.class)
                .block();
    }
}