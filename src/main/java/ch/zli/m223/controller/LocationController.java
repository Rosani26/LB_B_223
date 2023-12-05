package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.LocationService;

@Path("/categories")
@Tag(name = "Categories", description = "Handling of categories")
@RolesAllowed({ "User", "Admin" })
public class LocationController {

    @Inject
    LocationService locationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all categories.", 
        description = "Returns a list of all categories."
    )
    public List<Booking> index() {
        return locationService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new location.", 
        description = "Creates a new location and returns the newly added location."
    )
    public Booking create(Booking location) {
       return locationService.createLocation(location);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes an location.",
        description = "Deletes an location by its id."
    )
    public void delete(@PathParam("id") Long id) {
        locationService.deleteLocation(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates a location.",
        description = "Updates a location by its id."
    )
    public Booking update(@PathParam("id") Long id, Booking location) {
        return locationService.updateLocation(id, location);
    }

}
