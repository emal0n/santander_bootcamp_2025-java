package me.dio.domain.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    
    public AccountAlreadyExistsException(String accountNumber) {
        super(String.format("Account with number %s already exists.", accountNumber));
    }
}

