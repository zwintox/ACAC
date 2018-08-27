package com.example.acac;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Accident {
    private int ID;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]*$")
    private String Regnr;
    @NotEmpty
    private String Försäkringsbolag;
    private String Omständighet;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate Skadedag;
    @NotEmpty
    private String Skadeplats;
    @Size(max = 12, min = 10)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String DriverPersonalID;
    @NotEmpty
    private String DriverFirstName;
    @NotEmpty
    private String DriverLastName;
    @Size(max = 15, min = 7)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String DriverPhoneNumber;
    @NotEmpty
    private String Händelseförlopp;
    private String SkadorPåBilen;
    private boolean PolisPåPlats;
    private String Utandningsprov;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]*$")
    private String regnrmotpart;


    public Accident() {


    }


    public Accident(String Regnr,
                    String Försäkringsbolag,
                    String Omständighet,
                    LocalDate Skadedag,
                    String Skadeplats,
                    String DriverPersonalID,
                    String DriverFirstName,
                    String DriverLastName,
                    String DriverPhoneNumber,
                    String Händelseförlopp,
                    String SkadorPåBilen,
                    boolean PolisPåPlats,
                    String Utandningsprov,
                    String regnrmotpart) {

        this.Regnr = Regnr;
        this.Försäkringsbolag = Försäkringsbolag;
        this.Omständighet = Omständighet;
        this.Skadedag = Skadedag;
        this.Skadeplats = Skadeplats;
        this.DriverPersonalID = DriverPersonalID;
        this.DriverFirstName = DriverFirstName;
        this.DriverLastName = DriverLastName;
        this.DriverPhoneNumber = DriverPhoneNumber;
        this.Händelseförlopp = Händelseförlopp;
        this.SkadorPåBilen = SkadorPåBilen;
        this.PolisPåPlats = PolisPåPlats;
        this.Utandningsprov = Utandningsprov;
        this.regnrmotpart = regnrmotpart;


    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRegnr() {
        return Regnr;
    }

    public void setRegnr(String regnr) {
        Regnr = regnr;
    }

    public String getFörsäkringsbolag() {
        return Försäkringsbolag;
    }

    public void setFörsäkringsbolag(String försäkringsbolag) {
        Försäkringsbolag = försäkringsbolag;
    }

    public String getOmständighet() {
        return Omständighet;
    }

    public void setOmständighet(String omständighet) {
        Omständighet = omständighet;
    }

    public LocalDate getSkadedag() {
        return Skadedag;
    }

    public void setSkadedag(LocalDate skadedag) {
        Skadedag = skadedag;
    }

    public String getSkadeplats() {
        return Skadeplats;
    }

    public void setSkadeplats(String skadeplats) {
        Skadeplats = skadeplats;
    }

    public String getDriverPersonalID() {
        return DriverPersonalID;
    }

    public void setDriverPersonalID(String driverPersonalID) {
        DriverPersonalID = driverPersonalID;
    }

    public String getDriverFirstName() {
        return DriverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        DriverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return DriverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        DriverLastName = driverLastName;
    }

    public String getDriverPhoneNumber() {
        return DriverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        DriverPhoneNumber = driverPhoneNumber;
    }

    public String getHändelseförlopp() {
        return Händelseförlopp;
    }

    public void setHändelseförlopp(String händelseförlopp) {
        Händelseförlopp = händelseförlopp;
    }

    public String getSkadorPåBilen() {
        return SkadorPåBilen;
    }

    public void setSkadorPåBilen(String skadorPåBilen) {
        SkadorPåBilen = skadorPåBilen;
    }

    public boolean getPolisPåPlats() {
        return PolisPåPlats;
    }

    public void setPolisPåPlats(boolean polisPåPlats) {
        PolisPåPlats = polisPåPlats;
    }

    public String getUtandningsprov() {
        return Utandningsprov;
    }

    public void setUtandningsprov(String utandningsprov) {
        Utandningsprov = utandningsprov;
    }

    public String getRegnrmotpart() {
        return regnrmotpart;
    }

    public void setRegnrmotpart(String regnrmotpart) {
        this.regnrmotpart = regnrmotpart;
    }
}