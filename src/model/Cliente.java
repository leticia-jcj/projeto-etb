package model;

import lombok.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor //cria um construtor vazio
@Data
public class Cliente {
	
	private int idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String telefone;

}
