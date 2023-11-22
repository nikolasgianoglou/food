package com.example.algafoodapi.api.controller;


import com.example.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.model.CozinhasXmlWrapper;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import com.example.algafoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody // indica que as respostas desse controlador deve ir para a resposta da requisicao HTTP, posso usar a anotacao @RestController, que engloba a Controller e a ResponseBody
@RequestMapping(value = "/cozinhas") //posso colocar também produces
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Cozinha> listar() {
//        return cozinhaRepository.listar(); usando minha implementação
        return cozinhaRepository.findAll(); /** usando Spring JPA*/
    }

//    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
//    public CozinhasXmlWrapper listarXml() {
//        return new CozinhasXmlWrapper(cozinhaRepository.listar());
//    }

//    @ResponseStatus(value = HttpStatus.CREATED)
//    @GetMapping(value = "/{cozinhaId}")  // /cozinhas/{cozinhaId}
//    public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
//        return cozinhaRepository.buscar(id);
//    }

    @GetMapping(value = "/{cozinhaId}")  // /cozinhas/{cozinhaId}
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
//        Cozinha cozinha =  cozinhaRepository.buscar(id);
//        if (cozinha!=null) {
//            return ResponseEntity.ok(cozinha);
//        }

        Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

        if(cozinha.isPresent()) {
            return ResponseEntity.ok(cozinha.get());
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
        return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
//        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(id);
//        cozinhaAtual.setNome(cozinha.getNome());
        if(cozinhaAtual.isPresent()) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
            Cozinha cozinhaSalva = cadastroCozinha.salvar(cozinhaAtual.get());
            return ResponseEntity.ok(cozinhaSalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {

        try {
            cadastroCozinha.excluir(id);
            return ResponseEntity.noContent().build();
//            return ResponseEntity.notFound().build();
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }



}
