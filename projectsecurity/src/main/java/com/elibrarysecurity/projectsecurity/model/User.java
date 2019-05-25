package com.elibrarysecurity.projectsecurity.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private LocalDate registrationDate = LocalDate.now();
    private LocalDate lastOverdueGenerated;

    private double overduefine = 0.0;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckOutRecord> checkOutRecords;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckinRecord> checkinRecord;


    @Column(nullable=false)
    @NotBlank(message = "* First Name is required")
    private String firstname;

    @Column(name="middlename", nullable=true)
    private String middlename;

    @Column(nullable=false)
    @NotBlank(message = "* Last Name is required")
    private String lastname;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Username is required")
    private String username;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Email is required")
    @Email(message="{errors.invalid_email}")
    private String email;

    @Column(nullable=false)
    @NotBlank(message = "* Password is required")
    @Size(min=8)
    private String password;

    @ManyToMany(cascade=CascadeType.ALL)//.MERGE
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<UserType> roles = new ArrayList<>();

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getLastOverdueGenerated() {
        return lastOverdueGenerated;
    }

    public void setLastOverdueGenerated(LocalDate lastOverdueGenerated) {
        this.lastOverdueGenerated = lastOverdueGenerated;
    }

    public double getOverduefine() {
        return overduefine;
    }

    public void setOverduefine(double overduefine) {
        this.overduefine = overduefine;
    }

    public List<CheckOutRecord> getCheckOutRecords() {
        return checkOutRecords;
    }

    public void setCheckOutRecords(List<CheckOutRecord> checkOutRecords) {
        this.checkOutRecords = checkOutRecords;
    }

    public List<CheckinRecord> getCheckinRecord() {
        return checkinRecord;
    }

    public void setCheckinRecord(List<CheckinRecord> checkinRecord) {
        this.checkinRecord = checkinRecord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<UserType> getRoles() {
        return roles;
    }

    public void setRoles(List<UserType> roles) {
        this.roles = roles;
    }
}
