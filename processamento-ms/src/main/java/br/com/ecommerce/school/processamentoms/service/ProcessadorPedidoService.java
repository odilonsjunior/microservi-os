package br.com.ecommerce.school.processamentoms.service;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import br.com.ecommerce.school.processamentoms.repository.IEstoquePedido;
import br.com.ecommerce.school.processamentoms.repository.IGeradorNotaFiscal;
import org.springframework.stereotype.Service;

@Service
public class ProcessadorPedidoService implements IProcessadorPedidoService {

    private IGeradorNotaFiscal notaFiscal;

    private IEstoquePedido estoque;

    public ProcessadorPedidoService(IGeradorNotaFiscal notaFiscal, IEstoquePedido estoque) {
        this.notaFiscal = notaFiscal;
        this.estoque = estoque;
    }

    @Override
    public void processar(PedidoDTO pedido) {
        notaFiscal.gerar(pedido);

        estoque.executarBaixa(pedido.getProdutos());

        //produzir messagem de produto finalizado

    }
}
