package br.com.fuctura2;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura2.dao.LivroDAO;
import br.com.fuctura2.models.Escritor;
import br.com.fuctura2.models.Livro;

public class Aplicacao {

	public static int leiaInt(String num) {

		int n = 0;
		while (true) {
			try {
				n = Integer.valueOf(num);
			} catch (Exception e) {
				System.out.println("Erro, digite apenas números inteiros");
			}
			return n;
		}

	}

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste-JPA");
		Scanner entrada = new Scanner(System.in);
		int opc;

		while (true) {

			System.out.println("\nEscolha a opção");

			System.out.println("|---------------------------|");
			System.out.println("|   1 - Inserir Livro       |");
			System.out.println("|   2 - Listar livro        |");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");

			System.out.println("Opção ");
			opc = leiaInt(entrada.nextLine());

			if (opc == 1) {

				br.com.fuctura2.models.Escritor escritor = new Escritor();
				Livro livro = new Livro();

				System.out.println("-----------");
				System.out.println("  INSERIR  ");
				System.out.println("-----------");

				System.out.println("\nDigite o título do livro ");
				livro.setTitulo(entrada.nextLine());

				System.out.println("\nDigite o gênero do livro ");
				livro.setGenero(entrada.nextLine());

				System.out.println("\nDigite a editora do livro ");
				livro.setEditora(entrada.nextLine());

				System.out.println("\nDigite o nome do escritor ");
				escritor.setNome(entrada.nextLine());

				System.out.println("\nDigite a nacionalidade do escritor ");
				escritor.setNacionalidade(entrada.nextLine());

				System.out.println("\nDigite o e-mail do escritor ");
				escritor.setEmail(entrada.nextLine());

				livro.setEscritor(escritor);

				LivroDAO lr = new LivroDAO(emf);

				lr.inserir(livro);

			}

		}
	}
}
