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

    public void addNewAccident(String Regnr,
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
                               String regnrmotpart,
                               int ID) {
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(" EXEC CreateClaim @Regnr =?, @Försäkringsbolag =?, @Omständighet =?, @Skadedag =?, @Skadeplats =?, @DriverPersonalID =?, @DriverFirstName =?, @DriverLastName =?, @DriverPhoneNumber =?, @Händelseförlopp =?, @SkadorPåBilen =?, @PolisPåPlats =?, @Utandningsprov =?, @regnrmotpart =?, @memberID =?",  new String[]{"ID"});

            ps.setString(1, Regnr);
            ps.setString(2, Försäkringsbolag);
            ps.setString(3, Omständighet);
            ps.setDate(4, Skadedag);
            ps.setString(5, Skadeplats);
            ps.setString(6, DriverPersonalID);
            ps.setString(7, DriverFirstName);
            ps.setString(8, DriverLastName);
            ps.setString(9, DriverPhoneNumber);
            ps.setString(10, Händelseförlopp);
            ps.setString(11, SkadorPåBilen);
            ps.setBoolean(12, PolisPåPlats);
            ps.setString(13, Utandningsprov);         ps.setString(14, regnrmotpart);
            ps.setInt(15, ID);

            ps.executeQuery();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

