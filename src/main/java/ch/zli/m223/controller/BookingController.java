package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
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

import ch.zli.m223.model.Location;
import ch.zli.m223.service.BookingService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
@RolesAllowed({ "User", "Admin" })
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all entries.", description = "Returns a list of all entries.")
    public List<Location> index() {
        return bookingService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Booking.", description = "Creates a new Booking and returns the newly added Booking.")
    public Location create(@Valid Location entry) {
        return bookingService.createBooking(entry);
    }

    @Path("/{id}")
    @DELETE
    @Operation(summary = "Deletes an Booking.", description = "Deletes an Booking by its id.")
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an Booking.", description = "Updates an Booking by its id.")
    public Location update(@PathParam("id") Long id, @Valid Location entry) {
        return bookingService.updateBooking(id, entry);
    }

}