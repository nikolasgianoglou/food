package com.example.algafoodapi.di.notificacao;

import com.example.algafoodapi.di.model.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/* Como que defino se uma classe é um Bean do spring, componente do spring? Se eu quiser que o Spring encontre essa classe
e gerencie ela eu posso usar a anotacao @Component, essa é uma das formas
* */

//@Primary // notificador email é o meu bean principal, use ele para fazer a desambiguacao
//@Qualifier("email") //notacao para qualificar/identificar nosso componente, nela coloco uma identificacao
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmail implements Notificador {

    //private boolean caixaAlta;
    //private String hostServidorSmtp;

//    public NotificadorEmail(String hostServidorSmtp) {
//        this.hostServidorSmtp = hostServidorSmtp;
//    }

    @Override
    public void notificar(Client client, String msg) {
//        if (caixaAlta) {
//            msg = msg.toUpperCase();
//        }
        System.out.printf("Notificando %s através do e-mail %s: %s\n", client.getNome(), client.getEmail()/*, hostServidorSmtp*/, msg);
    }
//    public void setCaixaAlta(boolean caixaAlta) {
//        this.caixaAlta = caixaAlta;
//    }
}
