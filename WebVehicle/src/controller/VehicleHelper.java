package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.MakeModel;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
public class VehicleHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Vehicle");
	
	public void insertVehicle(MakeModel mm) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(mm);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<MakeModel> showAllVehicles(){
		EntityManager em = emfactory.createEntityManager();
		List<MakeModel> allVehicles=em.createQuery("SELECT i FROM MakeModel i").getResultList();
		return allVehicles;
	}
	
	public void deleteVehicle(MakeModel toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MakeModel>typedQuery=em.createQuery("select li from MakeModel li where li.make=:selectedMake and li.model=:selectedModel", MakeModel.class);
		
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel",toDelete.getModel());
		
		
		typedQuery.setMaxResults(1);
		
	
		MakeModel result = typedQuery.getSingleResult();
		
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	
	public MakeModel searchForVehicleBySerialNumber(int serialNumberToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MakeModel found = em.find(MakeModel.class, serialNumberToEdit);
		em.close();
		return found;
		
	}


	
	public void updateVehicle(MakeModel toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	
	public List<MakeModel> searchForVehicleByMake(String vehicleMake) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MakeModel> typedQuery = em.createQuery("select li from MakeModel li where li.make = :selectedMake", MakeModel.class);
		typedQuery.setParameter("selectedMake", vehicleMake);
		List<MakeModel> foundVehicle = typedQuery.getResultList();
		em.close();
		return foundVehicle;
	}

	
	public List<MakeModel> searchForVehicleByModel(String vehicleModel) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MakeModel> typedQuery = em.createQuery("select li from MakeModel li where li.model = :selectedModel", MakeModel.class);
		typedQuery.setParameter("selectedModel", vehicleModel);
		
		List<MakeModel> foundVehicle = typedQuery.getResultList();
		em.close();
		return foundVehicle;
	}
	
	public void cleanUp(){
		emfactory.close();
		}

}
