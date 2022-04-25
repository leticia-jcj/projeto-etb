package model;

import java.util.ArrayList;

public class TestandoListas {

	public static void main(String[] args) {
		
		String aula1 = "Modelando a classe Aula";
		String aula2 = "Conhecendo mais de listas";
		String aula3 = "Trabalhando com Cursos e Sets";
		
		ArrayList<String> aulas = new ArrayList<>();
		
		//adicionando elementos á lista
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		//removendo elementos da lista
		aulas.remove(0);
		System.out.println(aulas);
		
		//acessando elementos da lista
		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula é: " + primeiraAula);
		
		//size retorna o total de elementos
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println( "Aula " + (i+1) +": " + aulas.get(i));
		}
		
		//Mais uma forma de percorrer elementos, agora com Java 8.
		
		
		
	}

}
