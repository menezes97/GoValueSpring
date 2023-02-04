package com.example.govalue.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.govalue.config.BdConfig;
import com.example.govalue.model.Avaliacao;

@Service
public class AvaliacaoService {

    @Autowired
    // @Qualifier("mySQLDataSource")
	JdbcTemplate jdbcTemplate;

    // @Autowired
    // BdConfig dBConfig;
	
	public List<Avaliacao> minhasAvaliacoes(String email) {
		String sql = "SELECT\n"+
        "r_avaliacao.id_avaliacao,\n" + 
        "r_avaliacao.descricao_avaliacao,\n"+
        "r_avaliacao.data_inicio_vigencia,\n"+ 
        "r_avaliacao.data_fim_vigencia\n"+
        "FROM g_funcionarios\n"+
        "JOIN p_avaliacoes_funcionarios ON (g_funcionarios.id_funcionario = p_avaliacoes_funcionarios.id_funcionario)\n"+
        "JOIN r_avaliacao ON (r_avaliacao.id_avaliacao = p_avaliacoes_funcionarios.id_avaliacao)\n" +
        "JOIN g_usuario ON (g_usuario.id_usuario = g_funcionarios.id_usuario)\n" +
        "WHERE g_usuario.email = ? AND (CURRENT_DATE() <= r_avaliacao.data_fim_vigencia or r_avaliacao.data_fim_vigencia is null)\n";
		sql += "GROUP BY g_funcionarios.id_funcionario, r_avaliacao.descricao_avaliacao, g_usuario.email, p_avaliacoes_funcionarios.id_funcionario";
        // String email = "gabriel@gmail.com";
		
		List<Avaliacao> listaAvaliacao = new ArrayList<>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {email});
		// try (PreparedStatement p = dBConfig.primaryDataSource().getConnection().prepareStatement(sql);) {
        //     p.setString(1, email);
        //     ResultSet result = p.executeQuery();
        //     while(result.next()) {
        //         System.out.println(result.getString("descricao_avaliacao"));
        //     }

        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        

		for (Map<String, Object> row : rows) {
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setData_fim_vigencia((Date) row.get("data_fim_vigencia"));
            avaliacao.setData_inicio_vigencia((Date) row.get("data_inicio_vigencia"));
            avaliacao.setDescricao_avaliacao((String) row.get("descricao_avaliacao"));
            avaliacao.setId_avaliacao((int) row.get("id_avaliacao"));
            listaAvaliacao.add(avaliacao);
        }
		
		return listaAvaliacao;
	}
}
