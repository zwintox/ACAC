package com.example.acac;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Member {
    private int ID;
    @Size(max = 12, min = 10)
    @NumberFormat
    private String personalNumber;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String city;
    @NotEmpty
    private String address;
    @Max (99999)
    @NumberFormat
    private int zipCode;
    @Email
    private String eMail;
    @Size(max = 15, min = 7)
    @NumberFormat
    private String phoneNumber;
    @Size(max = 20, min = 8)
    private String password;

    public Member() {
    }


    public Member(String personalNumber,
                  String firstName,
                  String lastName,
                  String city,
                  String address,
                  int zipCode,
                  String eMail,
                  String phoneNumber,
                  String password) {

        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Member(int ID) {
        this.ID = ID;
    }

    public Member(int ID, String personalNumber, String eMail, String password) {
        this.ID = ID;
        this.personalNumber = personalNumber;
        this.eMail = eMail;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
