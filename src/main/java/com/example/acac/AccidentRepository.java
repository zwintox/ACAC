package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class AccidentRepository {

    Accident accident;

    @Autowired
    public DataSource dataSource;

    public List<List<Accident>> getMatchedAccidents() {
        Connection conn;
        List<List<Accident>> matchedAccidents = new ArrayList<List<Accident>>();

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("EXEC GetClaims");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                List<Accident> accidentPair = new ArrayList<>();
                accidentPair.add(new Accident(rs.getString("Regnr1"),
                        rs.getString("Försäkringsbolag1"),
                        rs.getString("Omständighet1"),
                        rs.getDate("Skadedag1").toLocalDate(),
                        rs.getString("Skadeplats1"),
                        rs.getString("DriverPersonalID1"),
                        rs.getString("DriverFirstName1"),
                        rs.getString("DriverLastName1"),
                        rs.getString("DriverPhoneNumber1"),
                        rs.getString("Händelseförlopp1"),
                        rs.getString("SkadorPåBilen1"),
                        rs.getBoolean("PolisPåPlats1"),
                        rs.getString("Utandningsprov1"),
                        rs.getString("regnrmotpart1")));


                accidentPair.add(new Accident(rs.getString("Regnr2"),
                        rs.getString("Försäkringsbolag2"),
                        rs.getString("Omständighet2"),
                        rs.getDate("Skadedag2").toLocalDate(),
                        rs.getString("Skadeplats2"),
                        rs.getString("DriverPersonalID2"),
                        rs.getString("DriverFirstName2"),
                        rs.getString("DriverLastName2"),
                        rs.getString("DriverPhoneNumber2"),
                        rs.getString("Händelseförlopp2"),
                        rs.getString("SkadorPåBilen2"),
                        rs.getBoolean("PolisPåPlats2"),
                        rs.getString("Utandningsprov2"),
                        rs.getString("regnrmotpart2")));

                        matchedAccidents.add(accidentPair);

            }
            conn.close();


        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return matchedAccidents;
    }

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

            if (rs.next()) {
                System.out.println(rs.getInt("ID"));
                return rs.getInt("ID");
            }
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void setSkickad(String Regnr1, String Regnr2){

        Connection conn;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("Exec SetSent @Regnr1=?, @Regnr2 =?");

            ps.setString(1, Regnr1);
            ps.setString(2, Regnr2);

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

