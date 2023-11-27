package com.example.algafoodapi.api.controller;

import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(value = "/cozinhas/por-nome")
    public List<Cozinha> buscarPorNome(@RequestParam("nome") String nome) { //O @RequestParam é opcional, o spring já faz esse Binding automaticamente
        //@RequestParam -> essa anotação adiciona o parametro na URL, ?nome=:nome
        return cozinhaRepository.findByNome(nome); //findBy é um prefixo que posso usar, posso add qualquer coisa entre o find e o By também, desde que nao seja key word
    }

    @GetMapping(value = "/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNome(String nome) {
        return cozinhaRepository.findEspecificByNome(nome);
    }
}
