package de.msg.javatraining.donationmanager.persistence.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table(name="donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="amount")
    @NonNull
    private int amount;

    @Column(name = "currency")
    @NonNull
    private String currency;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="campaign_id")
    private Campaign campaign;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="createdby_id")
    private User createdBy;

    @Column(name="createdDate")
    private LocalDate createdDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="donator_id")
    private Donator donator;

    @Column(name="approved")
    private boolean approved;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="approvedby_id")
    private User approvedBy;

    @Column(name="approveDate")
    private LocalDate approveDate;

    @Column(name="notes")
    private String notes;


}
