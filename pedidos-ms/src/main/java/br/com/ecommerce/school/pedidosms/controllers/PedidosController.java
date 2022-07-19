package br.com.ecommerce.school.pedidosms.controllers;

import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.services.ICriarPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private ICriarPedidoService service;

    public PedidosController(ICriarPedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity enviarPedidos(@RequestBody PedidoDTO pedidoDTO){

        service.enviarPedido(pedidoDTO);

        return ResponseEntity.ok().build();
    }
}
