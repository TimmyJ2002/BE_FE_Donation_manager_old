package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.ERole;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleRepositoryInterface {
  void saveRole(Role r);
  void deleteRole(Role r);
  List<Role> findAll();
  Role findByName(ERole name);
}
