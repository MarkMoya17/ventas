package com.venta.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.venta.repositorios.GenericRepository;

@Repository
public abstract class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> tipo;

	public GenericRepositoryJPA(Class<T> tipo) {
		this.tipo = tipo;
	}

	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	public T findOne(K k) {
		return em.find(tipo, k);
	}

	public Iterable<T> findAll() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<T> consulta = cb.createQuery(tipo);
		Root<T> raiz = consulta.from(tipo);
		consulta.select(raiz);
		TypedQuery<T> miconsulta = em.createQuery(consulta);
		return miconsulta.getResultList();
	}

	@Transactional
	public void save(T tipo) {
		em.persist(tipo);
	}
	
	@Transactional
	public void update(T tipo) {
		em.merge(tipo);
	}

	@Transactional
	public void delete(T tipo) {
		em.remove(em.merge(tipo));
	}

}



