package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import br.com.ecommerce.school.pedidosms.dto.EStatusCliente;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.exception.InvalidOrderException;
import br.com.ecommerce.school.pedidosms.helpers.ProdutoHelper;
import br.com.ecommerce.school.pedidosms.repository.IClienteRepository;
import br.com.ecommerce.school.pedidosms.repository.IPedidoProducer;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnviarPedidoService implements IEnviarPedidoService {

    private final IPedidoProducer pedidoProducer;

    private final IClienteRepository clienteRepository;

    private final IPedidoRepository repository;

    public EnviarPedidoService(
            IPedidoProducer pedidoProducer,
            IClienteRepository clienteService,
            IPedidoRepository repository) {

        this.pedidoProducer = pedidoProducer;
        this.clienteRepository = clienteService;
        this.repository = repository;
    }

    @Override
    public void enviarPedido(PedidoDTO pedidoDTO) {


        final Optional<ClienteDTO> clienteDTO
                = clienteRepository.buscar(pedidoDTO.getCliente());

        if (clienteDTO.isEmpty()) {
            throw new InvalidOrderException("Cliente não encontrado!");
        } else if (clienteDTO.get().getStatus() == EStatusCliente.BLOQUEADO) {
            throw new InvalidOrderException("Cliente possui conta bloqueada!");
        } else if (clienteDTO.get().getStatus() == EStatusCliente.INATIVO) {
            throw new InvalidOrderException("Cliente existente, porém, não possui ativa!");
        } else if (!pedidoDTO.getCliente().equals(clienteDTO.get().getCodigo())) {
            throw new InvalidOrderException("Código do cliente inválido!");
        }

        final Pedido pedido = new Pedido( pedidoDTO.getStatus(),
                pedidoDTO.getCliente(),
                ProdutoHelper.parseProdutosDto(pedidoDTO.getProdutos()));

        repository.save(pedido);

        pedidoProducer.enviarPedido(pedidoDTO);
    }
}
