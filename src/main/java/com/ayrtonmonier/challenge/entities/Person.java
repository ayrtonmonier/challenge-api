package com.ayrtonmonier.challenge.entities;

import java.util.List;

import com.ayrtonmonier.challenge.data.json.impl.PersonDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.JsonAdapter;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "persons")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAdapter(PersonDeserializer.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "gender")
    private String gender;

    @Embedded
    private Name name;

    @Embedded
    private Location location;

    @Column(name = "email")
    private String email;

    @Embedded
    @JsonProperty("birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Birthday birthday;

    @Embedded
    @JsonProperty("registered")
    @Temporal(TemporalType.TIMESTAMP)
    private Registered registered;

    @JsonProperty("phone")
    @ElementCollection
    @CollectionTable(name = "person_telephone_numbers", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "telephone_number")
    private List<String> telephoneNumbers;

    @JsonProperty("cell")
    @ElementCollection
    @CollectionTable(name = "person_mobile_numbers", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "mobile_number")
    private List<String> mobileNumbers;

    @Embedded
    private Picture picture;

    @Column(name = "nationality")
    private String nationality;

    // Construtores, getters e setters

    public Person() {}


    public Person(String type, String gender, Name name, Location location, String email,
    		Birthday birthday, Registered registered, List<String> telephoneNumbers,
                  List<String> mobileNumbers, String nationality, Picture picture) {
        this.type = type;
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.birthday = birthday;
        this.registered = registered;
        this.telephoneNumbers = telephoneNumbers;
        this.mobileNumbers = mobileNumbers;
        this.nationality = nationality;
        this.picture = picture;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
