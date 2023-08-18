package com.example.govalue.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.govalue.dao.AvaliacaoDao;
import com.example.govalue.model.Avaliacao;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoDao avaliacaoDao;

    public List<Avaliacao> getMinhasAvaliacoes(String email) {
        return avaliacaoDao.minhasAvaliacoes(email);
    }

}
