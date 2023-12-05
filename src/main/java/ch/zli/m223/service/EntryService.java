package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Location;

@ApplicationScoped
public class EntryService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Location createEntry(Location entry) {
        return entityManager.merge(entry);
    }

    @Transactional
    public void deleteEntry(Long id) {
        var entity = entityManager.find(Location.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Location updateEntry(Long id, Location entry) {
        entry.setId(id);
        return entityManager.merge(entry);
    }

    public List<Location> findAll() {
        var query = entityManager.createQuery("FROM Entry", Location.class);
        return query.getResultList();
    }
}
