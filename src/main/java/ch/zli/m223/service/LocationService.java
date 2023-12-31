package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Location;

@ApplicationScoped
public class LocationService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Location createLocation(Location location) {
        return entityManager.merge(location);
    }

    @Transactional
    public void deleteLocation(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }


    public List<Location> findAll() {
        var query = entityManager.createQuery("FROM location", Location.class);
        return query.getResultList();
    }
}