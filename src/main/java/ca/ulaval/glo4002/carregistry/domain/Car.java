package ca.ulaval.glo4002.carregistry.domain;

public class Car {

	private CarId id;
	private String plate;
	
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
