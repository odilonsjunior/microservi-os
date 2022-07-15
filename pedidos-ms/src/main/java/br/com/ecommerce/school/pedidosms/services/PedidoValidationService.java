package br.com.ecommerce.school.pedidosms.services;

import org.springframework.stereotype.Service;

@Service
public class PedidoValidationService implements IPedidoValidationService {

    @Override
    public Boolean isValido(String client) {
        return Boolean.TRUE;
    }
}
