package br.com.ecommerce.school.processamentoms.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    public static final String BEAN_NFE = "nfe";
    public static final String BEAN_PRODUTOS = "produtos";

    @Value("${url.server.nf}")
    private String urlNfe;

    @Value("${url.server.produtos}")
    private String urlProdutos;

    @Bean(name = BEAN_NFE)
    public WebClient getWebClienteNFE(){
        return  WebClient.builder()
                .baseUrl(urlNfe)
                .build();
    }

    @Bean(name = BEAN_PRODUTOS)
    public WebClient getWebClienProdutos(){
        return  WebClient.builder()
                .baseUrl(urlProdutos)
                .build();
    }
}
