package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.VehicleListDetails;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class VehicleListDetailsHelper {
	static EntityManagerFactory emfactory =Persistence.createEntityManagerFactory("Vehicle");
	
	public void insertNewVehicleListDetails(VehicleListDetails s) {
	EntityManager em =emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(s);
	em.getTransaction().commit();
	em.close();
	}
	public List<VehicleListDetails> getLists() {
	EntityManager em =emfactory.createEntityManager();
	List<VehicleListDetails> allDetails =em.createQuery("SELECT s FROM VehicleListDetails s").getResultList();
	return allDetails;
	}
	public void deleteVehicleList(VehicleListDetails toDelete) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VehicleListDetails> typedQuery = em.createQuery("select detail from VehicleListDetails detail where detail.id = :selectedId", VehicleListDetails.class);
	
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
	
		VehicleListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	
	}
	public VehicleListDetails  searchForVehicleListDetailsById(Integer tempId) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		VehicleListDetails found = em.find(VehicleListDetails.class, tempId);
		em.close();
		return found;
	}
	public void updateVehicleList(VehicleListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
