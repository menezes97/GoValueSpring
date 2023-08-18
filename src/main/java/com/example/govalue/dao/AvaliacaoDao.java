package com.example.govalue.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.govalue.model.Avaliacao;

@Transactional
@Repository
public class AvaliacaoDao {

    @Autowired
    @Qualifier("jdbcTemplace1")
    private JdbcTemplate mysql;

    // @Autowired
    // @Qualifier("jdbcTemplate2")
    // private JdbcTemplate postgres;

    public List<Avaliacao> minhasAvaliacoes(String email) {
        
        String sql = "SELECT\n"
                + "r_avaliacao.id_avaliacao,\n"
                + "r_avaliacao.descricao_avaliacao,\n"
                + "r_avaliacao.data_inicio_vigencia,\n"
                + "r_avaliacao.data_fim_vigencia\n"
                + "FROM g_funcionarios\n"
                + "JOIN p_avaliacoes_funcionarios ON (g_funcionarios.id_funcionario = p_avaliacoes_funcionarios.id_funcionario)\n"
                + "JOIN r_avaliacao ON (r_avaliacao.id_avaliacao = p_avaliacoes_funcionarios.id_avaliacao)\n"
                + "JOIN g_usuario ON (g_usuario.id_usuario = g_funcionarios.id_usuario)\n"
                + "WHERE g_usuario.email = ? AND (CURRENT_DATE() <= r_avaliacao.data_fim_vigencia or r_avaliacao.data_fim_vigencia is null)\n";
        sql += "GROUP BY g_funcionarios.id_funcionario, r_avaliacao.descricao_avaliacao, g_usuario.email, p_avaliacoes_funcionarios.id_funcionario";

        List<Avaliacao> listaAvaliacao = new ArrayList<>();

        try {
            List<Map<String, Object>> rows = mysql.queryForList(sql, new Object[]{email});
            for (Map<String, Object> row : rows) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setData_fim_vigencia((Date) row.get("data_fim_vigencia"));
                avaliacao.setData_inicio_vigencia((Date) row.get("data_inicio_vigencia"));
                avaliacao.setDescricao_avaliacao((String) row.get("descricao_avaliacao"));
                avaliacao.setId_avaliacao((int) row.get("id_avaliacao"));
                listaAvaliacao.add(avaliacao);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return listaAvaliacao;
    }
}
