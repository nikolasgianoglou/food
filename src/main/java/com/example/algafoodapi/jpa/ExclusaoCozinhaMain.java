package com.example.algafoodapi.jpa;

import com.example.algafoodapi.AlgafoodApiApplication;
import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import com.example.algafoodapi.infrastructure.repository.CozinhaRepositoryImp;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                                                    .web(WebApplicationType.NONE)
                                                    .run(args);
        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImp.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinha.setNome("Brasileira");
        cozinhaRepository.remover(cozinha);
    }
}
