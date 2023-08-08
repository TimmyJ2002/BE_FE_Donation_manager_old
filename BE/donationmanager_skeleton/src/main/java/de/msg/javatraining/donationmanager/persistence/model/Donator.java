package de.msg.javatraining.donationmanager.persistence.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name="donator")
public class Donator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname")
    @NonNull
    private String firstName;

    @Column(name="lastname")
    @NonNull
    private String lastName;

    @Column(name="additionalname")
    private String additionalName;

    @Column(name="maidenname")
    private String maidenName;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "donator"
    )
    private List<Donation> donationList;

}
