package com.example.algafoodapi.listener;

import com.example.algafoodapi.di.notificacao.NivelUrgencia;
import com.example.algafoodapi.di.notificacao.Notificador;
import com.example.algafoodapi.di.notificacao.TipoDoNotificador;
import com.example.algafoodapi.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getClient(), "Seu cadastro no sistema está ativo!");
    }
}
