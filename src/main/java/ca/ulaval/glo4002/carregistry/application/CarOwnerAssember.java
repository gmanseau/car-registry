package ca.ulaval.glo4002.carregistry.application;

import java.util.stream.Collectors;

import ca.ulaval.glo4002.carregistry.application.dto.CarDto;
import ca.ulaval.glo4002.carregistry.application.dto.CarOwnerDto;
import ca.ulaval.glo4002.carregistry.domain.Car;
import ca.ulaval.glo4002.carregistry.domain.CarOwner;

public class CarOwnerAssember {

	public CarOwnerDto toDto(CarOwner carOwner) {
		CarOwnerDto carOwnerDto = new CarOwnerDto();
		carOwnerDto.id = carOwner.getId().toInteger();
		carOwnerDto.name = carOwner.getName();
		carOwnerDto.cars = carOwner.getCars().stream().map(this::toDto).collect(Collectors.toList());
		return carOwnerDto;
	}

	public CarDto toDto(Car car) {
		CarDto carDto = new CarDto();
		carDto.id = car.getId().toInteger();
		carDto.plate = car.getPlate();
		return carDto;
	}

}
