package com.example.enums;

public enum TipoConta {
    ADMIN("Admin"),
    GERENTE("Gerente"),
    VENDEDOR("Vendedor"),
    CLIENTE("Cliente");
    private final String tipoConta;
    TipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}