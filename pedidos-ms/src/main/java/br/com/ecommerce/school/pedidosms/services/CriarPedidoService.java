package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.helpers.ProdutoHelper;
import br.com.ecommerce.school.pedidosms.repository.ICriarPedidoRepository;
import br.com.ecommerce.school.pedidosms.repository.IPedidoDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarPedidoService implements ICriarPedidoService {

    private ICriarPedidoRepository repository;

    private IPedidoDAO pedidoDAO;

    public CriarPedidoService(ICriarPedidoRepository repository, IPedidoDAO pedidoDAO) {
        this.repository = repository;
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public void criarPedido(PedidoDTO pedidoDTO) {

        final Pedido pedido = new Pedido(
                pedidoDTO.getStatus(),
                pedidoDTO.getCliente(),
                ProdutoHelper.parseProdutosDto(pedidoDTO.getProdutos()));

        pedidoDAO.save(pedido);

        final Optional<Pedido> cliente = pedidoDAO.findByCliente(pedido.getCliente());

        repository.criarPedido(pedidoDTO);
    }
}
