package br.com.ecommerce.school.pedidosms.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    public static final String BEAN_CLIENTE = "cliente";

    @Value("${url.server.cliente}")
    private String url;

    @Bean(name = BEAN_CLIENTE)
    public WebClient getWebClienteForClienteService() {
        return WebClient.builder()
                .baseUrl(url)
                .build();
    }
}
