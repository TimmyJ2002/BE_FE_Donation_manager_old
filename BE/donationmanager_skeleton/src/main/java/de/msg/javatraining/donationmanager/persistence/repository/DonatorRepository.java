package de.msg.javatraining.donationmanager.persistence.repository;

import de.msg.javatraining.donationmanager.persistence.model.Donator;

import java.util.List;

public interface DonatorRepository {
    void saveDonator(Donator u);
    void deleteDonator(Donator u);
    List<Donator> findAll();
    Donator findByID(int DonatorID);
}
