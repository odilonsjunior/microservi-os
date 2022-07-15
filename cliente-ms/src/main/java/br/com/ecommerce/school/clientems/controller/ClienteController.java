package br.com.ecommerce.school.clientems.controller;

import br.com.ecommerce.school.clientems.entity.Cliente;
import br.com.ecommerce.school.clientems.exception.ClientNotFoudException;
import br.com.ecommerce.school.clientems.service.IBuscarClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final IBuscarClienteService service;

    public ClienteController(IBuscarClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Cliente> buscar(String cliente) {
        final Optional<Cliente> buscar = service.buscar(cliente);

        if (buscar.isPresent()) {
            return ResponseEntity.ok(buscar.get());
        } else {
            throw new ClientNotFoudException("Cliente não encontrado...");
        }
    }

}
