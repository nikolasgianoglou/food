package com.example.algafoodapi.api.controller;


import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.model.CozinhasXmlWrapper;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@ResponseBody // indica que as respostas desse controlador deve ir para a resposta da requisicao HTTP, posso usar a anotacao @RestController, que engloba a Controller e a ResponseBody
@RequestMapping(value = "/cozinhas") //posso colocar também produces
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }

//    @ResponseStatus(value = HttpStatus.CREATED)
//    @GetMapping(value = "/{cozinhaId}")  // /cozinhas/{cozinhaId}
//    public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
//        return cozinhaRepository.buscar(id);
//    }

    @GetMapping(value = "/{cozinhaId}")  // /cozinhas/{cozinhaId}
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
        Cozinha cozinha =  cozinhaRepository.buscar(id);
        if (cozinha!=null) {
            return ResponseEntity.ok(cozinha);
        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.notFound().build();
    }


//    @GetMapping(value = "/{id}")  // /cozinhas/{cozinhaId}
//    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
//
//        Cozinha cozinha =  cozinhaRepository.buscar(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//        return ResponseEntity.ok(cozinha);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.LOCATION, "http://algafood.local:8080/cozinhas");
//        return ResponseEntity
//                .status(HttpStatus.FOUND)
//                .headers(headers)
//                .build();
//    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
//        cozinhaAtual.setNome(cozinha.getNome());
        if(cozinhaAtual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }

        return ResponseEntity.notFound().build();
    }

    
}
