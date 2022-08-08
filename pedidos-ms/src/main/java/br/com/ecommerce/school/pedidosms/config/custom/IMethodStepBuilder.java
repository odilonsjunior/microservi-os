package br.com.ecommerce.school.pedidosms.config.custom;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

public interface IMethodStepBuilder<T> {
    IMethodStepBuilder<T> withFilter(ExchangeFilterFunction filter);
    IMethodStepBuilder<T> withFilters(List<ExchangeFilterFunction> filters);
    IMethodStepBuilder<T> withHeaders(Map<String, String> headers);
    IMethodStepBuilder<T> withHeader(String key, String value);
    IBodyStepBuilder<T> withPut();
    IBuildStepBuilder<T> withGet();
    IBodyStepBuilder<T> withPost();
    WebClient getWebClient();
}
