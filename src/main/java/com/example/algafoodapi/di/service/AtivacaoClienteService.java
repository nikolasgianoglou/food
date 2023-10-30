package com.example.algafoodapi.di.service;

import com.example.algafoodapi.di.model.Client;
import com.example.algafoodapi.di.notificacao.Notificador;
import com.example.algafoodapi.di.notificacao.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    // outro ponto de injecao pode ser a propria variavel
    @Autowired(required = false) // quando passo o parametro required ele torna essa variavel opcional
    private Notificador notificador;

    // uma das formas de se fazer injeção de dependencia é por meio do construtor
    // se tiver mais de um construtor, o spring nao saberá qual utilizar, posso usar a anotação autowired para indicar qual quero usar
//    @Autowired
//    public AtivacaoClienteService(Notificador notificador) {
//        this.notificador = notificador;
//    }

//    public AtivacaoClienteService(String qualquer) {
//    }

    public void ativar(Client client) {
        client.ativar();
        if (notificador != null) {
            notificador.notificar(client, "Seu cadastro no sistema está ativo!!");
        } else {
            System.out.println("Nao existe notificador mas o cliente foi ativado");
        }

    }

    // outra forma de usar injecao de dependencia é por meio do set, nesse caso tem que usar a anotacao autowired
//    @Autowired
//    public void setNotificador(Notificador notificador) {
//        this.notificador = notificador;
//    }
}
