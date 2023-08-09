package de.msg.javatraining.donationmanager.persistence.repository.impl;

import de.msg.javatraining.donationmanager.persistence.model.Donator;
import de.msg.javatraining.donationmanager.persistence.repository.DonatorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class DonatorRepositoryImpl implements DonatorRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void saveDonator(Donator u) {
        em.persist(u);
    }

    @Override
    public void deleteDonator(Donator u) {
        em.remove(u);
    }

    @Override
    public List<Donator> findAll() {
        return em.createQuery("select u from Donator u", Donator.class).getResultList();
    }

    @Override
    public Donator findByID(int DonatorID) {
        return em.find(Donator.class, DonatorID);
    }


}
