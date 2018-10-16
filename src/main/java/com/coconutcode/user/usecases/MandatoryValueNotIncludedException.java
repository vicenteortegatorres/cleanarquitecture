package com.coconutcode.user.usecases;

public class MandatoryValueNotIncludedException extends RuntimeException {
    public MandatoryValueNotIncludedException(String error) {
        super(error);
    }
}
