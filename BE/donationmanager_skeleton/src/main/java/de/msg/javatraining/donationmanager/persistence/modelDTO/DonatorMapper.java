package de.msg.javatraining.donationmanager.persistence.modelDTO;


import de.msg.javatraining.donationmanager.persistence.model.Donator;
import org.springframework.stereotype.Component;

@Component
public class DonatorMapper {

    public Donator dtoToDonator(DonatorDTO dto) {
        Donator u = new Donator();
        u.setLastName(dto.getLastName());
        u.setFirstName(dto.getFirstName());
        u.setMaidenName(dto.getMaidenName());
        u.setAdditionalName(dto.getAdditionalName());
        return u;
    }

    public DonatorDTO donatorToDto(Donator u) {
        DonatorDTO dto = new DonatorDTO();
        dto.setFirstName(u.getFirstName());
        dto.setLastName(u.getLastName());
        dto.setMaidenName(u.getMaidenName());
        dto.setAdditionalName(u.getAdditionalName());
        return dto;
    }

}

