package de.msg.javatraining.donationmanager.persistence.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(	name = "user",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email")
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="firstname")
	@NonNull
	private String firstName;

	@Column(name="lastname")
	@NonNull
	private String lastName;

	@Column(name="email")
	@NonNull
	private String email;

	@Column(name="mobilenumber")
	private String mobileNumber;

	@Column(name="isactive")
	private boolean isActive;

	@Column(name="logincount")
	private int loginCount;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;


//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(	name = "user_campaign",
//			joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "campaign_id"))
	@ElementCollection
	@CollectionTable(
			name = "user_campaign",
			joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "campaign_id")
	private List<Integer> campaigns;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "createdBy"
	)
	private List<Donation> donationListCreated;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "approvedBy"
	)
	private List<Donation> donationListApproved;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "notificationReceiver"
	) 	private List<Notification> notifications;

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
