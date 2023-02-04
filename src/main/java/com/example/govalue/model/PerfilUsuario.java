package com.example.govalue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuario {
	
	private int id;
	private String descricao;
	private int moduloPesquisas;
	private int moduloAvaliacao;

}
