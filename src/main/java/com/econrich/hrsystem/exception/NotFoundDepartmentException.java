package com.econrich.hrsystem.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundDepartmentException extends RuntimeException {

    public NotFoundDepartmentException(String message) {
        super(message);
    }

}
