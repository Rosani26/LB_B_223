package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class LocationService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Booking createLocation(Booking location) {
        return entityManager.merge(location);
    }

    @Transactional
    public void deleteLocation(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateLocation(Long id, Booking location) {
        location.setId(id);
        return entityManager.merge(location);
    }

    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM location", Booking.class);
        return query.getResultList();
    }
}