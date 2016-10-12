package ca.ulaval.glo4002.carregistry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private CarId id;
	
	@Column
	private String plate;
	
	public Car() {
		// for hibernate
	}
	
	public Car(String plate) {
		this.plate = plate;
	}

	public CarId getId() {
		return id;
	}

	public void setId(CarId id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public boolean isNew() {
		return id == null || id.isNew();
	}
	
	
}
