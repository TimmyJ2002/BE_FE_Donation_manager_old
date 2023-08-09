package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.ERight;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import de.msg.javatraining.donationmanager.persistence.model.Role_Right;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRightRepoInterface {

    void saveRoleRight(Role role, ERight right);
    void deleteRoleRight(Role role, ERight right);
    List<Role_Right> findAll();

}
