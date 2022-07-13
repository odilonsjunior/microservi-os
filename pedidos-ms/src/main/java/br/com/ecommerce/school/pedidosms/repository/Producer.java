package br.com.ecommerce.school.pedidosms.repository;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Producer<T> {
    private final KafkaTemplate kafkaTemplate;

    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void enviar(String topico, T object){
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topico, key, object);
    }
}
