package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.exception.InvalidOrderException;
import br.com.ecommerce.school.pedidosms.helpers.ProdutoHelper;
import br.com.ecommerce.school.pedidosms.repository.IPedidoProducer;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnviarPedidoService implements IEnviarPedidoService {

    private final IPedidoProducer pedidoProducer;

    private final IPedidoValidationService validationService;

    private final IPedidoRepository repository;

    public EnviarPedidoService(
            IPedidoProducer pedidoProducer,
            IPedidoValidationService pedidoValidationService,
            IPedidoRepository repository) {

        this.pedidoProducer = pedidoProducer;
        this.validationService = pedidoValidationService;
        this.repository = repository;
    }

    @Override
    public void enviarPedido(PedidoDTO pedidoDTO) {

        final Pedido pedido = new Pedido(
                pedidoDTO.getStatus(),
                pedidoDTO.getCliente(),
                ProdutoHelper.parseProdutosDto(pedidoDTO.getProdutos()));

        if (!validationService.isValido(pedidoDTO.getCliente())) {
            throw new InvalidOrderException("Usuário já existente...");
        }

        repository.save(pedido);

        pedidoProducer.enviarPedido(pedidoDTO);
    }
}
