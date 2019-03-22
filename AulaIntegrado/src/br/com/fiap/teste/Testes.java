package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.AulaDAO;
import br.com.fiap.dao.impl.AulaDAOImpl;
import br.com.fiap.resource.AulaTO;

public class Testes {
	
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica =  Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		 EntityManager em = fabrica.createEntityManager();
		
		AulaTO a = new AulaTO();
		a.setMateria("IOS");
		a.setProfessor("Calypso");
		a.setSala("705");
		a.setQuantidade("42");
		
		AulaDAO dao = new AulaDAOImpl(em);

	
		try {
			dao.cadastrar(a);
			dao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
