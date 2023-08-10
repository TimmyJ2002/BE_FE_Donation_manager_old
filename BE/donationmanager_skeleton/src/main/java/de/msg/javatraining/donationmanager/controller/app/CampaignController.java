package de.msg.javatraining.donationmanager.controller.app;

import de.msg.javatraining.donationmanager.persistence.model.Campaign;
import de.msg.javatraining.donationmanager.persistence.modelDTO.CampaignDto;
import de.msg.javatraining.donationmanager.service.CampaignConverter;
import de.msg.javatraining.donationmanager.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService campaignService;
    private final CampaignConverter campaignConverter = new CampaignConverter();

    @GetMapping("/campaign")
    public List<CampaignDto> findAll() {
        List<Campaign> campaigns = campaignService.findAll();
        return campaigns.stream()
                .map(campaignConverter::campaignToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/campaign/{id}")
    public Optional<Campaign> findById(@PathVariable("id") int id) {
        return campaignService.findById(id);
    }

    @PostMapping("/campaign/create")
  //  @PreAuthorize("hasAuthority('CAMP_MANAGEMENT')")
    public ResponseEntity<String> createCampaign(@RequestBody Campaign campaign) {
        try {
            campaignService.create(campaign);
            return ResponseEntity.ok("Campaign added successfully.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Name already exists.");
        }
    }

//    @PutMapping("/campaign/{id}")
//    public CampaignDto updateUserById(@PathVariable("id") Long id, @RequestBody Campaign updateCampaign) {}

//    @DeleteMapping("/campaign/{id}")
//    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {}

}
