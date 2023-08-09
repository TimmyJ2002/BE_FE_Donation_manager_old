package de.msg.javatraining.donationmanager.persistence.modelDTO;

public class DonatorDTO {
    private String firstName;
    private String lastName;
    private String additionalName;
    private String maidenName;

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }
    // Constructors, getters, and setters

    public DonatorDTO() {
        // Default constructor
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
