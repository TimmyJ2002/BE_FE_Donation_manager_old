package de.msg.javatraining.donationmanager.service;

import de.msg.javatraining.donationmanager.persistence.model.Campaign;
import de.msg.javatraining.donationmanager.persistence.repository.CampaignRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    CampaignRepositoryImpl campaignRepository;

    public List<Campaign> findAll() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns;
    }

    public Optional<Campaign> findById(int id) {
        return Optional.ofNullable(campaignRepository.findById(id));
    }

    public void create(Campaign campaign) {
        campaignRepository.create(campaign);
    }

//    public Campaign update(Long id, Campaign updateCampaign) {}

//    public void deleteById(Long id) {}

}
