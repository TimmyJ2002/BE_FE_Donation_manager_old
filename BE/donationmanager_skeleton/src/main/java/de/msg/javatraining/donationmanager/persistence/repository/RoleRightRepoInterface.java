package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.ERight;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import de.msg.javatraining.donationmanager.persistence.model.Role_Right;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleRightRepoInterface {

    void saveRoleRight(Role_Right rr);
    void deleteRoleRight(Role_Right rr);
    List<Role_Right> findAll();

    Role_Right findByRoleAndRight

}
