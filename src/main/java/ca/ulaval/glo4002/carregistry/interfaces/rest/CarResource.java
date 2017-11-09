package ca.ulaval.glo4002.carregistry.interfaces.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.ulaval.glo4002.carregistry.application.RegistryApplicationService;
import ca.ulaval.glo4002.carregistry.application.dto.CarCreationRequest;
import ca.ulaval.glo4002.carregistry.domain.Car;
import ca.ulaval.glo4002.carregistry.domain.CarOwnerId;

@Path("/owners/{ownerId}/cars/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {
	
	private RegistryApplicationService registry;

	public CarResource() {
		registry = new RegistryApplicationService();
	}
	
	@POST
	public Response createCar(@PathParam("ownerId") int ownerId, CarCreationRequest request) {
		Car car = registry.addCar(new CarOwnerId(ownerId), request);
		return Response.created(URI.create("/owners/" + ownerId  + "/cars/" + car.getId())).build();
	}

}
