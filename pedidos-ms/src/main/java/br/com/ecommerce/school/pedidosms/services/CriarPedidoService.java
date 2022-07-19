package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import br.com.ecommerce.school.pedidosms.dto.EStatusCliente;
import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.exception.InvalidOrderException;
import br.com.ecommerce.school.pedidosms.exception.ProdutoSemEstoqueException;
import br.com.ecommerce.school.pedidosms.helpers.ItemPedidoHelper;
import br.com.ecommerce.school.pedidosms.repository.IClienteRepository;
import br.com.ecommerce.school.pedidosms.repository.IPedidoProducer;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import br.com.ecommerce.school.pedidosms.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CriarPedidoService implements ICriarPedidoService {

    private final IPedidoProducer pedidoProducer;

    private final IClienteRepository clienteRepository;

    private final IPedidoRepository pedidoRepository;

    private final IProdutoRepository produtoRepository;

    public CriarPedidoService(
            IPedidoProducer pedidoProducer,
            IClienteRepository clienteService,
            IPedidoRepository repository, IProdutoRepository produtoRepository) {

        this.pedidoProducer = pedidoProducer;
        this.clienteRepository = clienteService;
        this.pedidoRepository = repository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void enviarPedido(PedidoDTO pedidoDTO) {

        validarCliente(pedidoDTO);

        validarProduto(pedidoDTO);

        final Pedido pedido = new Pedido(pedidoDTO.getStatus(),
                pedidoDTO.getCliente(),
                ItemPedidoHelper.parseItemPedidoDTOS(pedidoDTO.getProdutos()));

        pedidoRepository.save(pedido);

        pedidoProducer.enviarPedido(pedido);
    }

    private void validarProduto(PedidoDTO pedidoDTO) {
        for (ItemPedidoDTO item : pedidoDTO.getProdutos()) {
            final Optional<ProdutoDTO> produto = produtoRepository.buscar(item);

            BigDecimal quantidadeSolicitada = item.getQuantidade();
            BigDecimal saldoEstoque = produto.get().getQuantidade();

            if (quantidadeSolicitada.compareTo(saldoEstoque) > 0) {
                throw new ProdutoSemEstoqueException("Produto sem estoque: " + item.getCodigo());
            }


        }
    }

    private void validarCliente(PedidoDTO pedidoDTO) {
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
    }
}
