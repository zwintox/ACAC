package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class AccidentRepository {

    @Autowired
    public DataSource dataSource;
    Connection conn = null;

    public void addNewAccident(int ID,
                                 Date Skadedag,
                                 String Regnr,
                                 String Försäkringsbolag,
                                 int DriverPersonalID,
                                 String DriverFirstName,
                                 String DriverLastName,
                                 int DriverPhoneNumber,
                                 String Händelseförlopp,
                                 String SkadorPåBilen) {
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(" INSERT INTO Accident (ID, " +
                    "Skadedag, " +
                    "Regnr, " +
                    "Försäkringsbolag, " +
                    "DriverPersonalID, " +
                    "DriverFirstName, " +
                    "DriverLastName, " +
                    "DriverPhoneNumber, " +
                    "Händelseförlopp, " +
                    "SkadorPåBilen) VALUES {?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"ID"});
            ps.setInt(1, (ID));
            ps.setDate(2, Skadedag);
            ps.setString(3, Regnr);
            ps.setString(4, Försäkringsbolag);
            ps.setInt(5, DriverPersonalID);
            ps.setString(6, DriverFirstName);
            ps.setString(7, DriverLastName);
            ps.setInt(8, DriverPhoneNumber);
            ps.setString(9, Händelseförlopp);
            ps.setString(10, SkadorPåBilen);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

