package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class CategoryService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Booking createCategory(Booking category) {
        return entityManager.merge(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateCategory(Long id, Booking category) {
        category.setId(id);
        return entityManager.merge(category);
    }

    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Category", Booking.class);
        return query.getResultList();
    }
}