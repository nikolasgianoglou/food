package com.example.algafoodapi.domain.service;

import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.model.Restaurante;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import com.example.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElseThrow(() -> (
                new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com codigo %d", cozinhaId))));
//        if(cozinha.isEmpty()){
//            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com codigo %d", cozinhaId));
//        }
        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }

//    public Restaurante atualizar(Restaurante restaurante) {
//        Optional<Restaurante> restauranteSalvo= restauranteRepository.findById(restaurante.getId());
//        return restauranteRepository.save(restauranteSalvo.get());
//    }

    public void excluir(Long id) {
        try {
            restauranteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe restaurante com o código %d", id)
            );
        }
    }
}
