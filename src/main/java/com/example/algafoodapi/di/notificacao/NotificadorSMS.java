package com.example.algafoodapi.di.notificacao;

import com.example.algafoodapi.di.model.Client;
import org.springframework.stereotype.Component;

@Component
public class NotificadorSMS implements Notificador{
    @Override
    public void notificar(Client client, String msg) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", client.getNome(), client.getTelefone()/*, hostServidorSmtp*/, msg);
    }

}
