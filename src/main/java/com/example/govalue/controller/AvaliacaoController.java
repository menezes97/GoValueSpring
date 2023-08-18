package com.example.govalue.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.govalue.model.Avaliacao;
import com.example.govalue.service.AvaliacaoService;

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/minhasAvaliacoes")
    public List<Avaliacao> getMinhasAvaliacoes(@RequestParam String email) {
        List<Avaliacao> listaAvaliacao = avaliacaoService.getMinhasAvaliacoes(email);
        return listaAvaliacao;
    }

}
