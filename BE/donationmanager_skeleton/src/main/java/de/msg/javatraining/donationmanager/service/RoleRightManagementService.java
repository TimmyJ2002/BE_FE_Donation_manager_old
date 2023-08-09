package de.msg.javatraining.donationmanager.service;

import de.msg.javatraining.donationmanager.persistence.repository.RoleRepositoryInterface;
import de.msg.javatraining.donationmanager.persistence.repository.RoleRightRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoleRightManagementService {

    @Qualifier("roleRepositoryInterface")
    @Autowired
    RoleRepositoryInterface roleRepo;

    @Qualifier("roleRightRepoInterfaceImpl")
    @Autowired
    RoleRightRepoInterface roleRightRepo;



}
