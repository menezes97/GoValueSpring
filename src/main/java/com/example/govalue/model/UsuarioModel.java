package com.example.govalue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
	
	private int id_usuario;
	private String nome_usuario;
	private boolean usuario_adm;
	private String email;
	private int id_perfil;

}
