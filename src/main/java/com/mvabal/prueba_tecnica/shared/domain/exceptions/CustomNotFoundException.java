package com.mvabal.prueba_tecnica.shared.domain.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class CustomNotFoundException extends NotFoundException {

    String message;

    public CustomNotFoundException(String message) {

        super();
        this.message = message;
    }

    public CustomNotFoundException() {
        super();
    }

    public String getMessage() {
        return message;
    }

    private static final long serialVersionUID = 1L;
}
