package model;

import lombok.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor //cria um construtor vazio
@Data
public class Produto {

	private int idProduto;
	private String nome;
	private String descricao;
	private int estoque;
	private double preco;
	private String nomeArquivo;
	private String caminho;
	private int status;
	
} 
