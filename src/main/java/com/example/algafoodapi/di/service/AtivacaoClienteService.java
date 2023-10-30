package com.example.algafoodapi.di.service;

import com.example.algafoodapi.di.model.Client;
import com.example.algafoodapi.di.notificacao.Notificador;
import com.example.algafoodapi.di.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

    // uma das formas de se fazer injeção de dependencia é por meio do construtor
    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void ativar(Client client) {
        client.ativar();
        notificador.notificar(client, "Seu cadastro no sistema está ativo!!");
    }
}
