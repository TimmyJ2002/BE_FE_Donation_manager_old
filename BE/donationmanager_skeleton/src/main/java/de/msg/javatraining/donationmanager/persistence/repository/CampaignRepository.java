package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository {
    void create(Campaign campaign);
    void delete(Campaign campaign);
    List<Campaign> findAll();
    Campaign findById(int id);
}
