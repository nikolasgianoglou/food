package com.example.algafoodapi.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //Diz que minha anotaçao pode ser lida em tempo de execucao, se nao colocar nao dá certo
@Qualifier
public @interface TipoDoNotificador {
    NivelUrgencia value();
}
