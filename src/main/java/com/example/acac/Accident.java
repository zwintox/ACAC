package com.example.acac;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.sql.Date;
import java.util.List;

public class Accident {
    private int ID;
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]*$")
    private String Regnr;
    @NotEmpty
    private String Försäkringsbolag;
    private String Omständighet;

    private Date Skadedag;
    @NotEmpty
    private String Skadeplats;
    @NotEmpty
    @Size (max=12, min=10)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String DriverPersonalID;
    private String DriverFirstName;
    private String DriverLastName;
    @NotEmpty
    private String DriverPhoneNumber;
    @NotEmpty
    private String Händelseförlopp;
    private String SkadorPåBilen;
    private boolean PolisPåPlats;
    private String Utandningsprov;
    @NotEmpty
    @Size (max=6, min=6)
    private String regnrmotpart;

    public Accident (){

    }


    public Accident(String Regnr,
                    String Försäkringsbolag,
                    String Omständighet,
                    Date Skadedag,
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

    public Date getSkadedag() {
        return Skadedag;
    }

    public void setSkadedag(Date skadedag) {
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