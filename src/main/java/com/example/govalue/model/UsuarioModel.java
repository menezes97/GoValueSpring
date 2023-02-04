package com.example.govalue.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
	
	private int id_usuario;
	private String nome_usuario;
	private Date data_inicio_vigencia;
	private Date data_fim_vigencia;
	private boolean usuario_adm;
	private String senha;
	private String email;
	private int id_perfil;

}
