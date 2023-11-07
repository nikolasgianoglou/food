package com.example.algafoodapi.jpa;

import com.example.algafoodapi.AlgafoodApiApplication;
import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.model.Restaurante;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import com.example.algafoodapi.domain.repository.RestauranteRepository;
import com.example.algafoodapi.infrastructure.repository.CozinhaRepositoryImp;
import com.example.algafoodapi.infrastructure.repository.RestauranteRepositoryImp;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                                                    .web(WebApplicationType.NONE)
                                                    .run(args);
        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepositoryImp.class);
        List<Restaurante> restaurantes = restauranteRepository.listar();
        for(Restaurante restaurante: restaurantes) {
            System.out.printf("%s - %f -%s\n",restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
        }
    }
}