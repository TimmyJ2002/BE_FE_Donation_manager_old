package de.msg.javatraining.donationmanager.persistence.repository.impl;

import de.msg.javatraining.donationmanager.persistence.model.ERight;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import de.msg.javatraining.donationmanager.persistence.model.Role_Right;
import de.msg.javatraining.donationmanager.persistence.repository.RoleRightRepoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class RoleRightRepoInterfaceImpl implements RoleRightRepoInterface {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveRoleRight(Role role, ERight right) {
        Role_Right rr = new Role_Right();
        rr.setRole(role);
        rr.setRoleRight(right);
        em.persist(rr);
    }

    @Override
    public void deleteRoleRight(Role role, ERight right) {
        Role_Right rr = new Role_Right();
        rr.setRole(role);
        rr.setRoleRight(right);
        em.remove(rr);
    }

    @Override
    public List<Role_Right> findAll() {
        return em.createQuery("select rr from Role_Right rr", Role_Right.class).getResultList();
    }
}
