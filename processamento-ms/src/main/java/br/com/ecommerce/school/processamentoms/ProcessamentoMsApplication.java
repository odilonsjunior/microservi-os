package br.com.ecommerce.school.processamentoms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ProcessamentoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessamentoMsApplication.class, args);
	}


	@Value("${url.gateway}")
	private String gateway;

	@Bean
	public WebClient getWebCliente(){
		return  WebClient.builder()
				.baseUrl(gateway)
				.build();
	}

}
