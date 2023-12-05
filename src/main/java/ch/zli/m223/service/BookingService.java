package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Location;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Location createBooking(Location booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        var entity = entityManager.find(Location.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Location updateBooking(Long id, Location booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }

    public List<Location> findAll() {
        var query = entityManager.createQuery("FROM Booking", Location.class);
        return query.getResultList();
    }
}
