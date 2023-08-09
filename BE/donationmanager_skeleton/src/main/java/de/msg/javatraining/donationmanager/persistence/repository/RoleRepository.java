package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.ERight;
import de.msg.javatraining.donationmanager.persistence.model.ERole;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository {

  void saveRole(Role r);
  void deleteRole(Role r);
  List<Role> findAll();
  Role findByName(ERole name);
  void addRolePermission(ERole roleName, ERight rightName);
  void removeRolePermission(ERole roleName, ERight rightName);
}
