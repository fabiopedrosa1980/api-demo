package br.com.pedrosa.api.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<E, PK extends Serializable> {

	public abstract void salvar(E entity);
	
	public abstract E salvarComRetorno(E entity);

	public abstract E alterar(E entity);

	public abstract E obtemPorId(PK primaryKey);

	public abstract void excluirPorId(PK primaryKey);

	public abstract Collection<E> pesquisarTodos();

	public abstract Page<E> pesquisarTodos(Pageable pageable);

	public abstract Collection<E> listarTodos();

}