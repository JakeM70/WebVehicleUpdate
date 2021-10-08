package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
@Entity
@Table(name="Make_Model")
public class MakeModel {
	@Id
	@GeneratedValue
	@Column(name="SERIAL_NUMBER")
	private int serialNumber;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	
	
	
	public int getSerialNumber() {
		return serialNumber;
	}

	
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public MakeModel() {
		
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	
	public MakeModel(String make, String model) {
		this.make = make;
		this.model = model;
	}
	
	public String returnMakeModel() {
		return this.make + ": " + this.model;
	}
	

}
