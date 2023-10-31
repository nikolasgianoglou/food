package com.example.algafoodapi.di.notificacao;

import com.example.algafoodapi.di.model.Client;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador {
    @Override
    public void notificar(Client client, String msg) {
        System.out.printf("MOCK: Notificacao seria enviada para %s através do e-mail %s: %s\n", client.getNome(), client.getEmail(), msg);
    }
}
