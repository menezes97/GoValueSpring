package com.example.govalue.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {
    
    private int id_avaliacao;
    private String descricao_avaliacao;
    private Date data_inicio_vigencia;
    private Date data_fim_vigencia;
    private int id_tipo_avaliacao;

}
