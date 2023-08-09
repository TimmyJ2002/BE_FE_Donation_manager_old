package de.msg.javatraining.donationmanager.persistence.repository.impl;

import de.msg.javatraining.donationmanager.persistence.model.ERight;
import de.msg.javatraining.donationmanager.persistence.model.ERole;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import de.msg.javatraining.donationmanager.persistence.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveRole(Role r) {
        em.persist(r);
    }

    @Override
    public void deleteRole(Role r) {
        em.remove(r);
    }

    @Override
    public List<Role> findAll() {
        return em.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role findByName(ERole name) {

        return em.find(Role.class, name);
    }

    @Override
    public void addRolePermission(ERole roleName, ERight rightName) {

    }

    @Override
    public void removeRolePermission(ERole roleName, ERight rightName) {

    }
}
