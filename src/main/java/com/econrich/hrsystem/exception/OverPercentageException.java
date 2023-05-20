package com.econrich.hrsystem.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OverPercentageException extends RuntimeException {

    public OverPercentageException(String message) {
        super(message);
    }

}
