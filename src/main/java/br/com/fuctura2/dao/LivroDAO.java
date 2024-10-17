package br.com.fuctura2.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.com.fuctura2.interfacedao.InterfaceDAO;
import br.com.fuctura2.models.Escritor;
import br.com.fuctura2.models.Livro;

public class LivroDAO implements InterfaceDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public LivroDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
		this.em = emf.createEntityManager();
	}

	@Override
	public void inserir(Livro livro) {

		try {

			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();

			em.close();

			System.out.println("\nLivro inserido com sucesso!");

		} catch (Exception e) {

			System.out.println("\nErro oa inserir livro");
		}

	}

	@Override
	public void listar(Integer id) {

		try {

			Livro livro = new Livro();

			livro = em.find(Livro.class, id);

			if (livro != null) {

				System.out.println(livro);
			} else {
				System.out.println("Livro com ID " + id + " não encontrado!!!\n");
			}

		} catch (Exception e) {
			System.out.println("ERRO " + e.getMessage());
		}

	}

	@Override
	public void atualizar(Livro livro) {

		try {

			Scanner entrada = new Scanner(System.in);

			Escritor escritor = livro.getEscritor();

			System.out.println("\nDigite a nova editora: ");
			livro.setEditora(entrada.nextLine());

			System.out.println("\nDigite a nova nacionalidade: ");
			escritor.setNacionalidade(entrada.nextLine());

			System.out.println("\nDigite o novo e-mail: ");
			escritor.setEmail(entrada.nextLine());

			livro.setEscritor(escritor);

			em.getTransaction().begin();
			em.getTransaction().commit();

			em.close();

			System.out.println("\nDados alterados com sucesso!!!\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Livro listarPorTitulo(String titulo) {

		try {

			TypedQuery<Livro> livro = em.createNamedQuery("Livro.consultarPoTitulo", Livro.class);
			livro.setParameter("titulo", titulo);
			return livro.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public void excluir(Livro livro) {
		
		try {
			
			em.getTransaction().begin();
			em.remove(livro);
			em.getTransaction().commit();
			
			em.close();
			
			System.out.println("\nLivro excluido com sucesso!!!\n");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
