package br.com.ecommerce.school.produtosms.service;

import br.com.ecommerce.school.produtosms.dto.QuantidadeDTO;
import br.com.ecommerce.school.produtosms.entity.Produto;
import br.com.ecommerce.school.produtosms.exception.ProdutoNaoEncontradoException;
import br.com.ecommerce.school.produtosms.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void processarEstoque(QuantidadeDTO pProduto, String codigo) {
        final Optional<Produto> produto = produtoRepository.findById(codigo);
        if (produto.isPresent()) {
            produto.get().calcularEstoque(pProduto.getQuantidade());
            produtoRepository.save(produto.get());
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }
    }

    @Override
    public Optional<Produto> buscar(String codigo) {
        return produtoRepository.findById(codigo);
    }
}
