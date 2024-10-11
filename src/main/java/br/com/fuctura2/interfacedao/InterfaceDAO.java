package br.com.fuctura2.interfacedao;

import br.com.fuctura2.models.Livro;

public interface InterfaceDAO {
	
	public void inserir(Livro livro);
	public Livro listar(Integer id);
	

}
