package model;

import lombok.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private int status;
	private Perfil perfil;

}
