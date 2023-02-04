package com.example.govalue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.govalue.model.UsuarioModel;

@Service
public class PerfilService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<UsuarioModel> getAllUser() {
		String sql = "SELECT id_usuario, nome_usuario, email FROM g_usuario WHERE 1=1 AND id_usuario = ?";
		int idUsuario = 1;
		
		List<UsuarioModel> listaUsuario = new ArrayList<>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {idUsuario});
		
		for (Map<String, Object> row : rows) {
            UsuarioModel usuario = new UsuarioModel();
            
            usuario.setId_usuario((Integer) row.get("id_usuario"));
			usuario.setNome_usuario((String) row.get("nome_usuario"));
			usuario.setEmail((String) row.get("email"));

            listaUsuario.add(usuario);
        }
		
		return listaUsuario;
	}
	
	
	
}
