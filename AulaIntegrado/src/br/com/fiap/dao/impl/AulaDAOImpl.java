package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AulaDAO;
import br.com.fiap.resource.AulaTO;

public class AulaDAOImpl extends GenericDAOImpl<AulaTO, Integer> implements AulaDAO{

	public AulaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
