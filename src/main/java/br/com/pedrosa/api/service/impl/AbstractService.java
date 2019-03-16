package br.com.pedrosa.api.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrosa.api.service.CrudService;


public abstract class AbstractService<E, PK extends Serializable> implements CrudService<E, PK> {
	
	@Autowired
	public ModelMapper modelMapper;
	
	private JpaRepository<E, PK> repository;

    public JpaRepository<E, PK> getRepository() {
        return repository;
    }

    public void setRepository(JpaRepository<E, PK> repository) {
        this.repository = repository;
    }

    public void salvar(E entity) {
        getRepository().save(entity);
    }
    
    public E salvarComRetorno(E entity) {
        return getRepository().save(entity);
    }

    public E alterar(E entity) {
        return getRepository().save(entity);
    }

    public E obtemPorId(PK primaryKey) {
    	E entity = getRepository().findById(primaryKey).orElse(null);
        if (entity == null) {
            new Exception("Data not found");
        }
    	return entity;
    }

    public void excluirPorId(PK primaryKey) {
    	E entity = getRepository().findById(primaryKey).orElse(null);
        if (entity == null) {
            new Exception("Data not found");
        }
        getRepository().deleteById(primaryKey);
    }

    public Collection<E> pesquisarTodos() {
        return getRepository().findAll();
    }

    public Page<E> pesquisarTodos(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public Collection<E> listarTodos() {
        return getRepository().findAll();
    }
    
}