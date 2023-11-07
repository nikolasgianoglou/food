package com.example.algafoodapi.jpa;

import com.example.algafoodapi.AlgafoodApiApplication;
import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import com.example.algafoodapi.infrastructure.repository.CozinhaRepositoryImp;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                                                    .web(WebApplicationType.NONE)
                                                    .run(args);
        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImp.class);
        Cozinha cozinha = cozinhaRepository.buscar(1L);

        System.out.println(cozinha.getNome());
    }
}
