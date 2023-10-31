package com.example.algafoodapi.di.service;

import com.example.algafoodapi.di.model.Client;
import com.example.algafoodapi.di.notificacao.NivelUrgencia;
import com.example.algafoodapi.di.notificacao.Notificador;
import com.example.algafoodapi.di.notificacao.NotificadorEmail;
import com.example.algafoodapi.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class AtivacaoClienteService {

    // outro ponto de injecao pode ser a propria variavel
//    @Autowired(required = false) // quando passo o parametro required ele torna essa variavel opcional
//    @Qualifier("email")
//    @TipoDoNotificador(NivelUrgencia.URGENTE)
//    @Autowired
//    private Notificador notificador;
    @Autowired
    private ApplicationEventPublisher eventPublisher;


    // uma das formas de se fazer injeção de dependencia é por meio do construtor
    // se tiver mais de um construtor, o spring nao saberá qual utilizar, posso usar a anotação autowired para indicar qual quero usar
//    @Autowired
//    public AtivacaoClienteService(Notificador notificador) {
//        this.notificador = notificador;
//    }

//    public AtivacaoClienteService(String qualquer) {
//    }
//    @PostConstruct
    public void init() {
        System.out.println("INIT");
    }
//    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY");
    }

    public void ativar(Client client) {
        client.ativar();

        eventPublisher.publishEvent(new ClienteAtivadoEvent(client));
//        notificador.notificar(client, "Seu cadastro no sistema está ativo!!");
        // Em vez de deixar a responsabilidade de notificar nessa classe, o que implicaria em baixa coesao, posso dizer para o container que o cliente está ativo nesse
        // momento
    }

    // outra forma de usar injecao de dependencia é por meio do set, nesse caso tem que usar a anotacao autowired
//    @Autowired
//    public void setNotificador(Notificador notificador) {
//        this.notificador = notificador;
//    }
}
