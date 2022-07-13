package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.repository.ICriarPedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoService implements ICriarPedidoService {

    private ICriarPedidoRepository repository;

    public CriarPedidoService(ICriarPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void criarPedido(PedidoDTO pedidoDTO) {

        repository.criarPedido(pedidoDTO);
    }
}
