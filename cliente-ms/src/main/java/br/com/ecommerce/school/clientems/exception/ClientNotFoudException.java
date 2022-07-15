package br.com.ecommerce.school.clientems.exception;

import org.springframework.http.HttpStatus;

public class ClientNotFoudException extends AbstractException {

    private static final long serialVersionUID = 574992678122876904L;

    public ClientNotFoudException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
