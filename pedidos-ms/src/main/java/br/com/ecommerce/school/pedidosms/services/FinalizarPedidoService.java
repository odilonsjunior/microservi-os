package br.com.ecommerce.school.pedidosms.services;


import br.com.ecommerce.school.pedidosms.dto.PedidoFinalizadoDTO;
import br.com.ecommerce.school.pedidosms.entity.EStatusPedido;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.exception.InvalidOrderException;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinalizarPedidoService implements IFinalizarPedidoService {

    private final IPedidoRepository pedidoRepository;

    public FinalizarPedidoService(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void finalizarPedido(PedidoFinalizadoDTO pedidoDTO) {

        final Optional<Pedido> cliente = pedidoRepository.findById(pedidoDTO.getCodigo());

        if (cliente.isEmpty()) {
            throw new InvalidOrderException("Cliente não encontrado!");
        }

        Pedido pedido = cliente.get();
        pedido.setStatus(EStatusPedido.FINALIZADO);
        pedidoRepository.save(pedido);
    }
}
