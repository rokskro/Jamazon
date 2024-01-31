package com.testing.model.pojos;

import com.testing.model.enums.SignOfTheStars;

import javax.persistence.*;

import com.testing.model.enums.SignOfTheStars;

import java.util.Date;

@Entity
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @Column(name="password")
    private String password;
    @Column(name="starsign")
    SignOfTheStars starSign;


    public Customer() {
        super();
    }
    
    @OneToOne(targetEntity = CustomerCard.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "cardID")
    private CustomerCard card;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
    
    
    
    public Customer(Long customerId, String firstName, String lastName, String email, String dateOfBirth, String password, SignOfTheStars starSign) {
        super();
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.starSign = starSign;
    }

    public Customer(Long customerId, String firstName, String lastName, String email, String dateOfBirth, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public SignOfTheStars getStarSign() {
        return starSign;
    }
    public void setStarSign(SignOfTheStars starSign) {
        this.starSign = starSign;
    }

}
