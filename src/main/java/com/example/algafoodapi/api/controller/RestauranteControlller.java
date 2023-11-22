package com.example.algafoodapi.api.controller;

import com.example.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;

import com.example.algafoodapi.domain.model.Restaurante;
import com.example.algafoodapi.domain.repository.RestauranteRepository;
import com.example.algafoodapi.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
/*** Indico que essa classe é uma Controller que atenderá requisicoes e tambem que suas respostas irão para o corpo da requisicao*/
@RequestMapping(value = "/restaurantes")
public class RestauranteControlller {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    @GetMapping(value = "/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        if(restaurante.isPresent()) {
            return ResponseEntity.ok(restaurante.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) // AFIRMA QUE SE A REQUISICAO RESULTAR EM SUCESSO ESSE SERA O STATUS DA RESPOSTA
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            restaurante = cadastroRestaurante.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurante);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante){
        Optional<Restaurante> restauranteAtual = restauranteRepository.findById(id);
        if(restauranteAtual.isPresent()){
            BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id");
            try {
                Restaurante restauranteSalvo = cadastroRestaurante.salvar(restauranteAtual.get());
                return ResponseEntity.ok().body(restauranteSalvo);
            } catch (EntidadeNaoEncontradaException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Restaurante> remover(@PathVariable Long id) {

        try {
            cadastroRestaurante.excluir(id);
            return ResponseEntity.noContent().build();
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PatchMapping("/{restauranteId}")
    public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos) {
        Restaurante restauranteAtual = restauranteRepository.findById(restauranteId).orElse(null);
        if(restauranteAtual==null) {
            return ResponseEntity.notFound().build();
        }

        merge(campos, restauranteAtual);

        return atualizar(restauranteId, restauranteAtual);
    }

    private  void merge(Map<String, Object> camposOrigem, Restaurante restauranteDestino) {
        ObjectMapper objectMapper = new ObjectMapper(); // Classe do jackson que faz a conversão da classe para json e vice versa
        Restaurante restauranteOrigem = objectMapper.convertValue(camposOrigem, Restaurante.class); //Converte o json insirido no corpo da requisicao na classe Restaurante
        //Faz as conversoes necessarias para nao precisar ficar fazendo checagem e conversao

        camposOrigem.forEach((String key, Object value) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, key); //Busca as propriedades da classe em questão e me dá acesso a elas em tempo de execução
            field.setAccessible(true); //Faço isso para acessar a propriedade que é privada
            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
//            ReflectionUtils.setField(field, restauranteDestino, value);
            ReflectionUtils.setField(field, restauranteDestino, novoValor);
        });
    }


}
