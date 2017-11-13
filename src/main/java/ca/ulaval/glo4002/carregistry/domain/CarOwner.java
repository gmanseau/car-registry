package ca.ulaval.glo4002.carregistry.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class CarOwner {
	
	private CarOwnerId id;
	private String name;
	private List<Car> cars = new LinkedList<>();

	public CarOwner() {
		// for hibernate
	}
	
	public CarOwner(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int getIdForHibernate() {
		if (id == null) {
			return CarOwnerId.NEW;
		}

		return id.toInteger();
	}
	
	private void setIdForHibernate(int id) {
		this.id = new CarOwnerId(id);
	}

	@Transient
	public CarOwnerId getId() {
		return id;
	}

	public void setId(CarOwnerId id) {
		this.id = id;
	}

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "owner")
	public List<Car> getCars() {
		return cars;
	}
	
	private void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	@Column
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
