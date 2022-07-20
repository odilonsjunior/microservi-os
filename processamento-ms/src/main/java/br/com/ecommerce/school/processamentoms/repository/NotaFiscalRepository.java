package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.config.WebClientConfig;
import br.com.ecommerce.school.processamentoms.dto.ErroNotificacaoDTO;
import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class NotaFiscalRepository implements INotaFiscalRepository {

    private final WebClient webClient;

    @Value("${uri.emissao.nf}")
    private String uri;

    private final INotificarErro notificarErro;

    public NotaFiscalRepository(@Qualifier(WebClientConfig.BEAN_NFE) WebClient webClient, INotificarErro notificarErro) {
        this.webClient = webClient;
        this.notificarErro = notificarErro;
    }

    @Override
    public void gerar(PedidoDTO pedido) {
        webClient.post().uri(uri)
                .body(BodyInserters.fromValue(pedido))
                .retrieve()
                .toEntity(String.class)
                .doOnError(throwable -> {
                    ErroNotificacaoDTO erroNotificacao = new ErroNotificacaoDTO(pedido.getCodigo(), "ERRO_PROCESSAMENTO", "processamento-ms");
                    notificarErro.notificar(erroNotificacao);
                })
                .block();
    }
}
