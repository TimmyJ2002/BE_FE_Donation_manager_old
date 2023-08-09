package de.msg.javatraining.donationmanager.controller.app;

import de.msg.javatraining.donationmanager.persistence.model.ERight;
import de.msg.javatraining.donationmanager.persistence.model.Role;
import de.msg.javatraining.donationmanager.persistence.model.Role_Right;
import de.msg.javatraining.donationmanager.service.RoleRightManagementService;
import de.msg.javatraining.donationmanager.utils.RequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RightController {

    @Autowired
    RoleRightManagementService roleRightManagementService;

    @PostMapping("roles/add")
    public void addRoleRight(@RequestBody RequestWrapper requestWrapper) {

        Role_Right rr = new Role_Right();
        rr.setRoleRight(requestWrapper.getRoleRight());
        rr.setRole(roleRightManagementService.findByID(requestWrapper.getRoleID()));

        roleRightManagementService.addRight(rr);
    }

    @PostMapping("roles/remove")
    public void removeRoleRight(@RequestBody RequestWrapper requestWrapper) {
        Role_Right rr = new Role_Right();
        rr.setRoleRight(requestWrapper.getRoleRight());
        rr.setRole(roleRightManagementService.findByID(requestWrapper.getRoleID()));

        roleRightManagementService.removeRight(rr);
    }

}
