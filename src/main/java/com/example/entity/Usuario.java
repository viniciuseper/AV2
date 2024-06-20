package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "autenticacao")
public class Usuario {

    @Id
    private String id;

    private String nome;

    private String senha;

    private String emailUser;

    private String tipo;

    public Usuario(String id, String nomeUsuario, String senha, String email, String tipoConta) {
        this.id = id;
        this.nome = nomeUsuario;
        this.senha = senha;
        this.emailUser = email;
        this.tipo = tipoConta;
    }

    public Usuario() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String email) {
        this.emailUser = email;
    }

    public String getTipoConta() {
        return tipo;
    }

    public void setTipoConta(String tipoUsuario) {
        this.tipo = tipoUsuario;
    }
}