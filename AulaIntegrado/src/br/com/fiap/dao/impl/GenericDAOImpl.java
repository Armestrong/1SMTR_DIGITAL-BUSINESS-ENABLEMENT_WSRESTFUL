package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

import br.com.fiap.dao.GenericDAO;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	
	

	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@PersistenceContext
	protected EntityManager em;

	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T tabela) {
		em.persist(tabela);
	}

	@Override
	public void atualizar(T tabela) {
		em.merge(tabela);
	}

	@Override
	public void remover(K codigo) throws Exception {
		T tabela = buscar(codigo);
		if (tabela == null) {
			throw new Exception("Registro nao encontrado");
		}
		em.remove(tabela);
	}

	@Override
	public T buscar(K codigo) {
		return em.find(classe, codigo);
	}

	@Override
	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new Exception("Erro ao gravar");
		}

	}
}