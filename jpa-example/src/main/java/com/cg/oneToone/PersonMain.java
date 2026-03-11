package com.cg.oneToone;

import java.time.LocalDate;
//import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonMain {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em =emf.createEntityManager();
		em.getTransaction().begin();
		Dl obj = new Dl(LocalDate.of(2032, 10, 12), LocalDate.of(2012, 10, 10), "LMV,HMV");
		Person p = new Person("Mansi", LocalDate.of(2002, 10, 10), obj);
		
		p.setDl(obj);
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Person Created...");
		
	}
}
