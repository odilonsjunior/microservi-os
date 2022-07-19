package br.com.ecommerce.school.pedidosms.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    public static final String BEAN_CLIENTE = "cliente";

    public static final String BEAN_PRODUTO = "produto";

    @Value("${url.server.cliente}")
    private String urlCliente;


    @Value("${url.server.produto}")
    private String urlProduto;

    @Bean(name = BEAN_CLIENTE)
    public WebClient getWebClienteForClienteService() {
        return WebClient.builder()
                .baseUrl(urlCliente)
                .build();
    }

    @Bean(name = BEAN_PRODUTO)
    public WebClient getWebClientProduto() {
        return WebClient.builder()
                .baseUrl(urlProduto)
                .build();
    }
}
