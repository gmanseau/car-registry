package ca.ulaval.glo4002.carregistry.infrastructure.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ca.ulaval.glo4002.carregistry.domain.Car;
import ca.ulaval.glo4002.carregistry.domain.CarId;
import ca.ulaval.glo4002.carregistry.domain.CarOwner;
import ca.ulaval.glo4002.carregistry.domain.CarOwnerId;
import ca.ulaval.glo4002.carregistry.domain.CarRegistry;

public class InMemoryCarRegistry implements CarRegistry {
	private static final int MAX_ID = 9999;
	
	private static Random idGenerator = new Random();
	private static Map<CarOwnerId, CarOwner> owners = new HashMap<>();

	public CarOwner findOwner(CarOwnerId ownerId) {
		return owners.get(ownerId);
	}
	
	public void insert(CarOwner owner) {
		CarOwnerId id = new CarOwnerId(idGenerator.nextInt(MAX_ID));
		owner.setId(id);
		owners.put(id, owner);
	}

	public void update(CarOwner owner) {
		for(Car car : owner.getCars()) {
			if(car.isNew()) {
				car.setId(new CarId(idGenerator.nextInt(MAX_ID)));
			}
		}
		
		owners.put(owner.getId(), owner);
	}

	@Override
	public Collection<CarOwner> findAllOwners() {
		return owners.values();
	}

}
