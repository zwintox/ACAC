package com.example.acac;

import java.sql.Date;
import java.util.List;

public class Accident {
    private int ID;
    private String Regnr;
    private String Försäkringsbolag;
    private String Omständighet;
    private Date Skadedag;
    private String Skadeplats;
    private String DriverPersonalID;
    private String DriverFirstName;
    private String DriverLastName;
    private String DriverPhoneNumber;
    private String Händelseförlopp;
    private String SkadorPåBilen;
    private boolean PolisPåPlats;
    private String Utandningsprov;

    public Accident(int ID,
                    String Regnr,
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
                    String Utandningsprov) {
        this.ID = ID;
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

    public boolean isPolisPåPlats() {
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
}