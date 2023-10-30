package com.example.algafoodapi;

import com.example.algafoodapi.di.model.Client;
import com.example.algafoodapi.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Client joao = new Client("Joao", "Joao@xyz.com", "43543543534");
        ativacaoClienteService.ativar(joao);
        return "xxxxxx";
    }
}
