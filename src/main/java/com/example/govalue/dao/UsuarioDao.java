package com.example.govalue.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.govalue.model.UsuarioModel;

@Transactional
@Repository
public class UsuarioDao {

    @Autowired
    @Qualifier("jdbcTemplace1")
    private JdbcTemplate mysql;

    public List<UsuarioModel> getUser(int idUsuario) {
        List<UsuarioModel> listaUsuario = new ArrayList<>();
        String sql = "SELECT * FROM g_usuario U WHERE U.ID_USUARIO = ?";

        try {
            List<Map<String, Object>> rows = mysql.queryForList(sql, new Object[]{idUsuario});
            for (Map<String, Object> row : rows) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId_usuario((int) row.get("id_usuario"));
                usuario.setNome_usuario((String) row.get("nome_usuario"));
                usuario.setEmail((String) row.get("email"));
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return listaUsuario;
    }

}
