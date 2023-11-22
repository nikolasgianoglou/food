package com.example.algafoodapi.api.controller;

import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;
//
//    @GetMapping(value = "/cozinhas/por-nome")
//    public List<Cozinha> buscarPorNome(@RequestParam("nome") String nome) {
//        //@RequestParam -> essa anotação adiciona o parametro na URL, ?nome=:nome
//        return cozinhaRepository.buscarPorNome(nome);
//    }
}
