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
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(" INSERT INTO Accident (ID, " +
                    "Regnr, " +
                    "Försäkringsbolag, " +
                    "Omständighet," +
                    "Skadedag, " +
                    "Skadeplats, " +
                    "DriverPersonalID, " +
                    "DriverFirstName, " +
                    "DriverLastName, " +
                    "DriverPhoneNumber, " +
                    "Händelseförlopp, " +
                    "SkadorPåBilen," +
                    "PolisPåPlats," +
                    "Utandningsprov) VALUES {?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"ID"});
            ps.setInt(1, (ID));
            ps.setString(2, Regnr);
            ps.setString(3, Försäkringsbolag);
            ps.setString(4, Omständighet);
            ps.setDate(5, Skadedag);
            ps.setString(6, Skadeplats);
            ps.setString(7, DriverPersonalID);
            ps.setString(8, DriverFirstName);
            ps.setString(9, DriverLastName);
            ps.setString(10, DriverPhoneNumber);
            ps.setString(11, Händelseförlopp);
            ps.setString(12, SkadorPåBilen);
            ps.setBoolean(12, PolisPåPlats);
            ps.setString(12, Utandningsprov);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

