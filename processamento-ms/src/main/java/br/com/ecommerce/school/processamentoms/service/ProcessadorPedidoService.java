package br.com.ecommerce.school.processamentoms.service;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import br.com.ecommerce.school.processamentoms.dto.PedidoFinalizadoDTO;
import br.com.ecommerce.school.processamentoms.repository.IEstoquePedidoRepository;
import br.com.ecommerce.school.processamentoms.repository.INotaFiscalRepository;
import br.com.ecommerce.school.processamentoms.repository.IPedidoFinalizadoProducer;
import org.springframework.stereotype.Service;

@Service
public class ProcessadorPedidoService implements IProcessadorPedidoService {

    private INotaFiscalRepository notaFiscal;

    private IEstoquePedidoRepository estoque;

    private IPedidoFinalizadoProducer producer;

    public ProcessadorPedidoService(INotaFiscalRepository notaFiscal, IEstoquePedidoRepository estoque,
                                    IPedidoFinalizadoProducer producer) {
        this.notaFiscal = notaFiscal;
        this.estoque = estoque;
        this.producer = producer;
    }

    @Override
    public void processar(PedidoDTO pedido) {
        notaFiscal.gerar(pedido);

        //baixar estoque
        pedido.getProdutos().forEach(p -> estoque.executarBaixa(p));


        //produzir messagem de produto finalizado
        producer.finalizarPedido(new PedidoFinalizadoDTO(pedido.getCodigo(), "FINALIZADO", "Pronto para retirada"));

    }
}
