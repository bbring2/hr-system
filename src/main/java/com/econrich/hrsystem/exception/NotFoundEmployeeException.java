package com.econrich.hrsystem.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEmployeeException extends RuntimeException {

    public NotFoundEmployeeException(String message) {
        super(message);
    }

    public NotFoundEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

}
