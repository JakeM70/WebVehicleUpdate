package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Buyer;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class BuyerHelper {
	static EntityManagerFactory emfactory =Persistence.createEntityManagerFactory("Vehicle");
	
	public void insertBuyer(Buyer b) {
	EntityManager em =emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(b);
	em.getTransaction().commit();
	em.close();
	}
	public List<Buyer> showAllBuyers() {
	EntityManager em =emfactory.createEntityManager();
	List<Buyer> allBuyers = em.createQuery("SELECT b FROM Buyer b").getResultList();
	return allBuyers;
	}
	public Buyer findBuyer(String nameToLookUp) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select bu from Buyer bu where bu.buyerName = :selectedName",Buyer.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Buyer foundBuyer;
		
		try{
		foundBuyer = typedQuery.getSingleResult();
		}catch(NoResultException ex) {
		foundBuyer =new Buyer(nameToLookUp);
		}
		em.close();
		return foundBuyer;
	}
}
