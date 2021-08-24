package com.passenger.services.entity;

import javax.persistence.*;

@Entity
@Table(name = "info")
public class Passenger {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String firstName;
        private String lastName;
        private int passportId;
        private String email;

    public Passenger(){}

    public Passenger(String firstName, String lastName, int passportId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.email = email;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "passport_id", nullable = false)
    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
