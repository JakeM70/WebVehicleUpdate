package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
@Entity
public class VehicleListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String vehicleListName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Buyer buyer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<MakeModel> listOfVehicles;
	
	
	public VehicleListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VehicleListDetails(int id, String vehicleListName, LocalDate tripDate, Buyer buyer,
			List<MakeModel> listOfVehicles) {
		super();
		this.id = id;
		this.vehicleListName = vehicleListName;
		this.tripDate = tripDate;
		this.buyer = buyer;
		this.listOfVehicles = listOfVehicles;
	}

	public VehicleListDetails(String vehicleListName, LocalDate tripDate, Buyer buyer, List<MakeModel> listOfVehicles) {
		super();
		this.vehicleListName = vehicleListName;
		this.tripDate = tripDate;
		this.buyer = buyer;
		this.listOfVehicles = listOfVehicles;
	}
	
	public VehicleListDetails(String vehicleListName, LocalDate tripDate, Buyer buyer) {
		super();
		this.vehicleListName = vehicleListName;
		this.tripDate = tripDate;
		this.buyer = buyer;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVehicleListName() {
		return vehicleListName;
	}
	
	public void setVehicleListName(String vehicleListName) {
		this.vehicleListName = vehicleListName;
	}
	
	public LocalDate getTripDate() {
		return tripDate;
	}
	
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
	
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public List<MakeModel> getListOfVehicles() {
		return listOfVehicles;
	}
	
	public void setListOfVehicles(List<MakeModel> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}

	@Override
	public String toString() {
		return "VehicleListDetails [id=" + id + ", vehicleListName=" + vehicleListName + ", tripDate=" + tripDate
				+ ", buyer=" + buyer + ", listOfVehicles=" + listOfVehicles + "]";
	}
	
	

}
