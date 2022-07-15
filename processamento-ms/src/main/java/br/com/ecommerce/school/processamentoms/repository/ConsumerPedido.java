package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerPedido<T> {

    private IGeradorNotaFiscal nfe;

    public ConsumerPedido(IGeradorNotaFiscal nfe) {
        this.nfe = nfe;
    }

    @KafkaListener(topics = "${criar.pedido}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final PedidoDTO  pedidoDTO) {
        nfe.gerar(pedidoDTO);
    }

}
