package com.example.algafoodapi;

import com.example.algafoodapi.di.notificacao.Notificador;
import com.example.algafoodapi.di.notificacao.NotificadorEmail;
import com.example.algafoodapi.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// serve para definicoes de beans, também é um Componente
//@Configuration
public class AlgaConfig {

    //indica que esse método instancia, configura e inicializa um novo objeto que é gerenciado pelo container
    @Bean
    public NotificadorEmail notificadorEmail() {
//        NotificadorEmail notificador = new NotificadorEmail("smtp.email.com.br");
        NotificadorEmail notificador = new NotificadorEmail();


        //notificador.setCaixaAlta(true);
        return notificador;
    }

    @Bean
    public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
        return new AtivacaoClienteService(notificador);
    }
}
