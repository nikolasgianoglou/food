package com.example.algafoodapi.di.notificacao;

import com.example.algafoodapi.di.model.Client;

public interface Notificador {
    void notificar(Client client, String msg);
}
