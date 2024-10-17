package br.com.fuctura2;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura2.dao.LivroDAO;
import br.com.fuctura2.models.Escritor;
import br.com.fuctura2.models.Livro;

public class Aplicacao {

	public static int leiaInt(String message) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while (true) {
			try {
				System.out.println(message);
				n = Integer.parseInt(scan.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Erro, digite apenas números inteiros");
			}
		}
		return n;
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
			System.out.println("|   3 - Atualizar livro     |");
			System.out.println("|   4 - Excluir livro       |");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");
			System.out.println("|---------------------------|");

			opc = leiaInt("Opção");

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

			} else if (opc == 2) {

				System.out.println("-----------");
				System.out.println("  LISTAR   ");
				System.out.println("-----------");

				Integer id = leiaInt("\nDigite o identificador do livro: ");

				LivroDAO livroDAO = new LivroDAO(emf);

				livroDAO.listar(id);

			} else if (opc == 3) {

				System.out.println("-----------");
				System.out.println(" ATUALIZAR ");
				System.out.println("-----------");

				System.out.println("\nDigite o título do livro: ");
				String titulo = entrada.nextLine();

				LivroDAO livroDAO = new LivroDAO(emf);

				Livro livro = livroDAO.listarPorTitulo(titulo);

				if (livro != null) {
					livroDAO.atualizar(livro);
				} else {
					System.out.println("\nLivro não encontrado!!!\n");
				}

			} else if (opc == 4) {

				System.out.println("-----------");
				System.out.println("  EXCLUIR  ");
				System.out.println("-----------");

				System.out.println("\nDigite o título do livro: ");
				String titulo = entrada.nextLine();

				LivroDAO livroDAO = new LivroDAO(emf);

				Livro livro = livroDAO.listarPorTitulo(titulo);

				if (livro != null) {
					livroDAO.excluir(livro);
				} else {
					System.out.println("\nLivro não encontrado!!!\n");
				}
			}
		}
	}
}
