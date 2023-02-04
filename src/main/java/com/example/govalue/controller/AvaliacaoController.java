package com.example.govalue.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.govalue.model.Avaliacao;
import com.example.govalue.service.AvaliacaoService;

@RestController
public class AvaliacaoController {

    @Autowired
	AvaliacaoService avaliacaoService;
	
	@PostMapping("/minhasAvaliacoes")
	public List<Avaliacao> getMinhasAvaliacoes(@RequestParam String email) {
		List<Avaliacao> listaAvaliacao = avaliacaoService.minhasAvaliacoes(email);
		return listaAvaliacao;
	}
    
}
