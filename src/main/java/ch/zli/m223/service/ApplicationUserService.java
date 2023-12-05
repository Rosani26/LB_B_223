package ch.zli.m223.service;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public ApplicationUser createUser(ApplicationUser user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        var entity = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public ApplicationUser updateUser(Long id, ApplicationUser user) {
        user.setId(id);
        return entityManager.merge(user);
    }

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    public Optional<ApplicationUser> findByEmail(String email) {
        return entityManager
                .createNamedQuery("ApplicationUser.findByEmail", ApplicationUser.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
     public String loginAppUser(String email, String password){
        var query = entityManager.createQuery("FROM AppUser WHERE email = :email", ApplicationUser.class);
        query.setParameter("email", email);
        ApplicationUser applicationUser = query.getSingleResult();
        if (applicationUser.getPassword().equals(password)){
            Set<String>groups= new HashSet<>();
            if (applicationUser.admin()){
                groups.add("admin");
            }
            else{
                groups.add("member");
            }
            return Jwt.upn(email).groups(groups).claim("user_id", applicationUser.getId()).expiresIn(Duration.ofHours(24)).sign();
        }
        return null;

    }

}
