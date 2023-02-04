package com.example.govalue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.govalue.model.UsuarioModel;
import com.example.govalue.service.PerfilService;

@RestController
public class UsuarioController {
	
	@Autowired
	PerfilService perfilService;
	
	@GetMapping("/usuarios")
	public List<UsuarioModel> getAllUser() {
		List<UsuarioModel> listaUsuarios = perfilService.getAllUser();
		return listaUsuarios;
	}
	
}
