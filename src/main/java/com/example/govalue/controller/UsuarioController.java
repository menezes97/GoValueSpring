package com.example.govalue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.govalue.model.UsuarioModel;
import com.example.govalue.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<UsuarioModel> getAllUser(@RequestParam Integer idUsuario) {
        List<UsuarioModel> listaUsuarios = usuarioService.getUser(idUsuario);
        return listaUsuarios;
    }

}
