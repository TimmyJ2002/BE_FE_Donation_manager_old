package de.msg.javatraining.donationmanager.persistence.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name="campaign",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
})

public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="purpose")
    @NonNull
    private String purpose;

    @Column(name="name")
    @NonNull
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "campaign"
    )
    private List<Donation> donationList;

}
