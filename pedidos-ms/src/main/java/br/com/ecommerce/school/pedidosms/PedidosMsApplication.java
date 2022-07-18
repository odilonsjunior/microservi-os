package br.com.ecommerce.school.pedidosms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaRepositories
public class PedidosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosMsApplication.class, args);
	}

	@Value("${url.gateway}")
	private String gateway;

	@Bean
	public WebClient getWebCliente() {
		return WebClient.builder()
				.baseUrl(gateway)
				.build();
	}
}
