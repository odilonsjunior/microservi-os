package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.helpers.ProdutoHelper;
import br.com.ecommerce.school.pedidosms.repository.IPedidoProducer;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnviarPedidoService implements IEnviarPedidoService {

    private IPedidoProducer pedidoProducer;

    private IPedidoRepository repository;

    public EnviarPedidoService(IPedidoProducer pedidoProducer, IPedidoRepository repository) {
        this.pedidoProducer = pedidoProducer;
        this.repository = repository;
    }

    @Override
    public void enviarPedido(PedidoDTO pedidoDTO) {

        final Pedido pedido = new Pedido(
                pedidoDTO.getStatus(),
                pedidoDTO.getCliente(),
                ProdutoHelper.parseProdutosDto(pedidoDTO.getProdutos()));

        repository.save(pedido);

        pedidoProducer.enviarPedido(pedidoDTO);
    }
}
