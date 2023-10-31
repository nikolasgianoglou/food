package com.example.algafoodapi.di.service;

import com.example.algafoodapi.di.model.Client;

public class ClienteAtivadoEvent {
    private Client client;

    public ClienteAtivadoEvent(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
