package com.cg.main;

import java.time.LocalDate;

import com.cg.entity.Product;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	public static void main(String[] args) {

		// Product p1 = new Product(104, "Google IPAD", 195000, 10, LocalDate.of(2026,
		// 1, 10));

//   EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
//   EntityManager em = emf.createEntityManager();
//   // EntityManager is a interface which provide a apti which work with a  methood.
//	//createEntityManager() is a method of EntityManager
//   
//   EntityTransaction tx = em.getTransaction();
//	tx.begin();
//	em.persist(p1);
//	tx.commit();
//	System.out.println("Product Created...");

		
//	em.getTransaction().begin();
		//Product p = em.find(Product.class, 101);
//	//p.setDouble(60000);
//	if(p != null) {
//		em.remove(p);
//		System.out.println(p);	}
//	else 
//		System.out.println("Product Not Found");
//	em.getTransaction().commit();

		// This return the boolean value
//		boolean b = em.contains(p);
//		System.out.println(b);

		// I WANT TO READ ALL THE DATA FROM THE DATABASE
//	Query q = em.createQuery("Select p from Product p");
//	List<Product> li = q.getResultList();
//	li.forEach(p->System.out.println(p));
		
		Product p = new Product(104, "Google IPAD", 195000, 10, LocalDate.of(2026, 1, 10));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println(p);

	}

}

/*
 * PERSSTENCE LIFE CYCLE STEP 1 : DOESN'T EXIXT Product p1 = null;
 * 
 * STEP 2 : NEW p1 = new Product(104, "Google IPAD", 195000, 10,
 * LocalDate.of(2026, 1, 10));
 * 
 * STEP 3: MANAGED when call persist context. product p = em.find(Product.class,
 * 120); Sopln(p);
 * 
 * product p = em.find(Product.class, 120); if(p != null) Sopln(p); else
 * sopln("Product not found");
 * 
 * STEP 4: DETACHED em.remove(p); If product is present then remove it.
 * 
 * STEP 5:
 */
