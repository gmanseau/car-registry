package ca.ulaval.glo4002.carregistry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Car {

	private CarId carId;
	private String plate;
	
	public Car() {
		// for hibernate
	}
	
	public Car(String plate) {
		this.plate = plate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int getIdForHibernate() {
		if (carId == null) {
			return CarId.NEW; 
		}

		return carId.toInteger();
	}
	
	private void setIdForHibernate(int id) {
		this.carId = new CarId(id);
	}

	@Transient
	public CarId getId() {
		return carId;
	}

	public void setId(CarId id) {
		this.carId = id;
	}

	@Column
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@Transient
	public boolean isNew() {
		return carId == null || carId.isNew();
	}
	
	
}
