package com.example.acac;

import java.sql.Date;
import java.util.List;

public class Accident {
    private int ID;
    private String Regnr;
    private String Försäkringsbolag;
    private String Omständighet;
    private Date Skadedag;
    private String SkadePlats;
    private String EgnaSkador;
    private int DriverPersonalID;
    private String DriverFirstName;
    private String DriverLastName;
    private int DriverPhoneNumber;
    private String Händelseförlopp;
    private String SkadorPåBilen;
    private String Polis;

    public String getOmständighet() {
        return Omständighet;
    }

    public void setOmständighet(String omständighet) {
        Omständighet = omständighet;
    }

    public String getSkadePlats() {
        return SkadePlats;
    }

    public void setSkadePlats(String skadePlats) {
        SkadePlats = skadePlats;
    }

    public String getEgnaSkador() {
        return EgnaSkador;
    }

    public void setEgnaSkador(String egnaSkador) {
        EgnaSkador = egnaSkador;
    }

    public String getPolis() {
        return Polis;
    }

    public void setPolis(String polis) {
        Polis = polis;
    }

    public Accident(int ID,
                    Date skadedag,
                    String regnr,
                    String försäkringsbolag,
                    int driverPersonalID,
                    String driverFirstName,
                    String driverLastName,
                    int driverPhoneNumber,
                    String händelseförlopp,
                    String skadorPåBilen) {
        this.ID = ID;
        Skadedag = skadedag;
        Regnr = regnr;
        Försäkringsbolag = försäkringsbolag;
        DriverPersonalID = driverPersonalID;
        DriverFirstName = driverFirstName;
        DriverLastName = driverLastName;
        DriverPhoneNumber = driverPhoneNumber;
        Händelseförlopp = händelseförlopp;
        SkadorPåBilen = skadorPåBilen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getSkadedag() {
        return Skadedag;
    }

    public void setSkadedag(Date skadedag) {
        Skadedag = skadedag;
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

    public int getDriverPersonalID() {
        return DriverPersonalID;
    }

    public void setDriverPersonalID(int driverPersonalID) {
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

    public int getDriverPhoneNumber() {
        return DriverPhoneNumber;
    }

    public void setDriverPhoneNumber(int driverPhoneNumber) {
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
}
