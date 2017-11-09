package ca.ulaval.glo4002.carregistry.interfaces.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.ulaval.glo4002.carregistry.application.RegistryApplicationService;
import ca.ulaval.glo4002.carregistry.application.dto.CarOwnerDto;

@Path("/owners")
@Produces(MediaType.APPLICATION_JSON)
public class CarOwnerResource {
	private RegistryApplicationService registryService;

	public CarOwnerResource() {
		this.registryService = new RegistryApplicationService();
	}
	
	@GET
	public List<CarOwnerDto> getCarOwners() {
		return registryService.getCarOwners();
	}

}
