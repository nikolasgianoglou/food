package com.example.algafoodapi.api.controller;

import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.model.Restaurante;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import com.example.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping(value = "/cozinhas/por-nome")
    public List<Cozinha> buscarPorNome(@RequestParam("nome") String nome) { //O @RequestParam é opcional, o spring já faz esse Binding automaticamente
        //@RequestParam -> essa anotação adiciona o parametro na URL, ?nome=:nome
        return cozinhaRepository.findTodasByNome(nome); //findBy é um prefixo que posso usar, posso add qualquer coisa entre o find e o By também, desde que nao seja key word
    }

    @GetMapping(value = "/cozinhas/por-nome-containing")
    public List<Cozinha> buscarPorNomeContaining(@RequestParam("nome") String nome) {
        return cozinhaRepository.findTodasByNomeContaining(nome);
    }

    @GetMapping(value = "/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNome(String nome) {
        return cozinhaRepository.findEspecificByNome(nome);
    }

    @GetMapping(value = "/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantePorTaxaFrete(@RequestParam("taxaInicial") BigDecimal taxaInicial,@RequestParam("taxaFinal") BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping(value = "/restaurantes/por-nome")
    public List<Restaurante> restaurantePorNome(@RequestParam String nome,@RequestParam Long cozinhaId) {
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
    }

    @GetMapping(value = "/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantePrimeiroPorNome(@RequestParam String nome) {
        return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
    }

    @GetMapping(value = "/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(@RequestParam String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping(value = "/cozinha/exists")
    public boolean cozinhaExists(String nome) {
        return cozinhaRepository.existsByNome(nome);
    }

    @GetMapping(value = "/restaurantes/count-por-cozinha")
    public int cozinhaCount(Long cozinhaId) {
        return restauranteRepository.countByCozinhaId(cozinhaId);
    }

}
