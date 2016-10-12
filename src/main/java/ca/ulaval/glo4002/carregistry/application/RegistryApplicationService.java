package ca.ulaval.glo4002.carregistry.application;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ca.ulaval.glo4002.carregistry.application.dto.CarCreationRequest;
import ca.ulaval.glo4002.carregistry.application.dto.CarOwnerDto;
import ca.ulaval.glo4002.carregistry.domain.Car;
import ca.ulaval.glo4002.carregistry.domain.CarFactory;
import ca.ulaval.glo4002.carregistry.domain.CarOwner;
import ca.ulaval.glo4002.carregistry.domain.CarOwnerId;
import ca.ulaval.glo4002.carregistry.domain.CarRegistry;
import ca.ulaval.glo4002.carregistry.infrastructure.persistence.HibernateCarRegistry;

public class RegistryApplicationService {

	private CarRegistry carRegistry;
	private CarFactory carFactory;
	private CarOwnerAssember carOwnerAssember;

	public RegistryApplicationService() {
		this.carRegistry = new HibernateCarRegistry();
		this.carFactory = new CarFactory();
		this.carOwnerAssember = new CarOwnerAssember();
	}

	public Car addCar(CarOwnerId ownerId, CarCreationRequest request) {
		CarOwner owner = this.carRegistry.findOwner(ownerId);

		Car car = this.carFactory.createNewCar(request.carPlate);
		owner.addCar(car);

		carRegistry.update(owner);
		return car;

	}

	public List<CarOwnerDto> getCarOwners() {
		Collection<CarOwner> carOwners = this.carRegistry.findAllOwners();
		return carOwners.stream().map(carOwnerAssember::toDto).collect(Collectors.toList());
	}

}
