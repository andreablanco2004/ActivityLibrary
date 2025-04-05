package com.example.library.model;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patrons") // Especifica el nombre de la tabla en la base de datos
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente los IDs
    private Long patronId;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Size(max = 100)
    @Column(unique = true, nullable = false)
    private String email;

    @Size(max = 15)
    private String phoneNumber;

    @Size(max = 50)
    private String state;

    @Size(max = 10)
    private String zipCode;

    private Date dateOfBirth;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "DATE DEFAULT SYSDATE")
    private Timestamp registrationDate;

    @Size(max = 20)
    @Column(nullable = false)
    private String membershipStatus = "Active";

    private Date lastVisit;

    // Getters y Setters
    public Long getPatronId() {
        return patronId;
    }

    public void setPatronId(Long patronId) {
        this.patronId = patronId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
}
