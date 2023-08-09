package de.msg.javatraining.donationmanager.controller.app;

import de.msg.javatraining.donationmanager.persistence.model.Donator;
import de.msg.javatraining.donationmanager.persistence.modelDTO.DonatorDTO;
import de.msg.javatraining.donationmanager.persistence.modelDTO.DonatorMapper;
import de.msg.javatraining.donationmanager.persistence.repository.impl.DonatorRepositoryImpl;
import de.msg.javatraining.donationmanager.service.DonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DonatorController {
    @Autowired
    private DonatorService donatorService;
    private final DonatorMapper donatorMapper = new DonatorMapper();
    @GetMapping("/donator")
    public List<DonatorDTO> findAll() {
        List<Donator> donators = donatorService.findAll();
        return donators.stream()
                .map(donatorMapper::donatorToDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/donator/create")
    public void createDonator(@RequestBody Donator c){
        donatorService.saveDonator(c);
    }
}
