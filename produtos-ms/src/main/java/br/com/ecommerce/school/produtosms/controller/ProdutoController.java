package br.com.ecommerce.school.produtosms.controller;

import br.com.ecommerce.school.produtosms.dto.QuantidadeDTO;
import br.com.ecommerce.school.produtosms.service.IProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PutMapping("/{produto}")
    public ResponseEntity buscar(@PathVariable(required=false,name="produto")  String produto,
                                          @RequestBody QuantidadeDTO quantidade) {

        produtoService.processarEstoque(quantidade, produto);

        return ResponseEntity.ok().build();
    }
}
