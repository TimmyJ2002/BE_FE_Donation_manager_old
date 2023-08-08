package de.msg.javatraining.donationmanager.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name="role-right")
public class Role_Right {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 64)
    private ERight roleRight;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
