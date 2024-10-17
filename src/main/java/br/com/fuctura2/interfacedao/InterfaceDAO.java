package br.com.fuctura2.interfacedao;

import br.com.fuctura2.models.Livro;

public interface InterfaceDAO {
	
	public void inserir(Livro livro);
	public void listar(Integer id);
	public void atualizar(Livro livro);
	public Livro listarPorTitulo(String titulo);
	public void excluir(Livro livro);
	

}
