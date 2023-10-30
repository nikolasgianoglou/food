package com.example.algafoodapi.di.model;

public class Client {
    private String nome;
    private String email;
    private String telefone;
    private boolean ativo= false;

    public Client(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void ativar() {
        this.ativo = ativo;
    }
}
