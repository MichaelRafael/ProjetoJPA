package br.com.fuctura2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fuctura2.interfacedao.InterfaceDAO;
import br.com.fuctura2.models.Livro;

public class LivroDAO implements InterfaceDAO{
	
	private EntityManagerFactory emf;

	public LivroDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void inserir(Livro livro) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
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
	public Livro listar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
