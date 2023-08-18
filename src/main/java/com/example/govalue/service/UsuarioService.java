package com.example.govalue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.govalue.dao.UsuarioDao;
import com.example.govalue.model.UsuarioModel;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public List<UsuarioModel> getUser(Integer idUsuario) {

        List<UsuarioModel> listaUsuario = new ArrayList<>();

        try {
            listaUsuario = usuarioDao.getUser(idUsuario);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return listaUsuario;
    }

}
