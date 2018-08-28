package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.*;


import java.time.LocalDate;


@Component
public class AccidentRepository {

    Accident accident;

    @Autowired
    public DataSource dataSource;


    public int addNewAccident(String Regnr,
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
                               String regnrmotpart,
                               int ID) {
        Connection conn;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(" EXEC CreateClaim @Regnr =?, @Försäkringsbolag =?, @Omständighet =?, @Skadedag =?, @Skadeplats =?, @DriverPersonalID =?, @DriverFirstName =?, @DriverLastName =?, @DriverPhoneNumber =?, @Händelseförlopp =?, @SkadorPåBilen =?, @PolisPåPlats =?, @Utandningsprov =?, @regnrmotpart =?, @memberID =?");

            ps.setString(1, Regnr);
            ps.setString(2, Försäkringsbolag);
            ps.setString(3, Omständighet);
            ps.setDate(4, Date.valueOf(Skadedag));
            ps.setString(5, Skadeplats);
            ps.setString(6, DriverPersonalID);
            ps.setString(7, DriverFirstName);
            ps.setString(8, DriverLastName);
            ps.setString(9, DriverPhoneNumber);
            ps.setString(10, Händelseförlopp);
            ps.setString(11, SkadorPåBilen);
            ps.setBoolean(12, PolisPåPlats);
            ps.setString(13, Utandningsprov);
            ps.setString(14, regnrmotpart);
            ps.setInt(15, ID);


            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println(rs.getInt("ID"));
                return rs.getInt("ID");
            }
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

