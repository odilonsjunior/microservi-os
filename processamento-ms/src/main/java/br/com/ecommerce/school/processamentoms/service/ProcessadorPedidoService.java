package br.com.ecommerce.school.processamentoms.service;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import br.com.ecommerce.school.processamentoms.repository.IEstoquePedidoRepository;
import br.com.ecommerce.school.processamentoms.repository.INotaFiscalRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessadorPedidoService implements IProcessadorPedidoService {

    private INotaFiscalRepository notaFiscal;

    private IEstoquePedidoRepository estoque;

    public ProcessadorPedidoService(INotaFiscalRepository notaFiscal, IEstoquePedidoRepository estoque) {
        this.notaFiscal = notaFiscal;
        this.estoque = estoque;
    }

    @Override
    public void processar(PedidoDTO pedido) {
        notaFiscal.gerar(pedido);

        //baixar estoque
        pedido.getProdutos().forEach(p -> estoque.executarBaixa(p));


        //produzir messagem de produto finalizado

    }
}
