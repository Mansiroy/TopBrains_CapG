package com.cg.Entity;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class empMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Emp> r = cq.from(Emp.class);
		
		cq.multiselect(r.get("department"), cb.count(r));
		cq.groupBy(r.get("department"));
		TypedQuery<Object[]> tq = em.createQuery(cq);
		List<Object[]> li = tq.getResultList();
		li.forEach(o-> System.out.println("DepartmentName :" +o[0]+"\t"+"total employee:" +o[1]));
	}
}
