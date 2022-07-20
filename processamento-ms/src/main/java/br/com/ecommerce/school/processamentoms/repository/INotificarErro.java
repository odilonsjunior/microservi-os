package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.ErroNotificacaoDTO;

public interface INotificarErro {
    void notificar(ErroNotificacaoDTO dto);
}
