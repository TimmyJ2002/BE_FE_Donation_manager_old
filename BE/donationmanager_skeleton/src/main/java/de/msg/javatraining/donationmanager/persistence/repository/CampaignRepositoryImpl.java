package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.Campaign;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CampaignRepositoryImpl implements CampaignRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Campaign campaign) {
        entityManager.persist(campaign);
    }

    @Override
    public void delete(Campaign campaign) {
        entityManager.remove(campaign);
    }

    @Override
    public List<Campaign> findAll() {
        return entityManager.createQuery("SELECT c FROM Campaign c", Campaign.class).getResultList();
    }

    @Override
    public Campaign findById(int id) {
        return entityManager.find(Campaign.class, id);
    }
}
