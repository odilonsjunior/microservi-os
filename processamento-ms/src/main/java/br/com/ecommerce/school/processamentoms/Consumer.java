package br.com.ecommerce.school.processamentoms;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer<T> {

    @KafkaListener(topics = "${criar.pedido}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final PedidoDTO  consumerRecord) {
        System.out.println("key: " );
//        System.out.println("Headers: " + consumerRecord.headers());
//        System.out.println("Partion: " + consumerRecord.partition());
//        System.out.println("Order: " + consumerRecord.value());
    }

}
