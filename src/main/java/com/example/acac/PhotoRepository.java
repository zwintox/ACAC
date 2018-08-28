package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class PhotoRepository {
    @Autowired
    public DataSource dataSource;

    Connection conn = null;


    public void addPhoto(String source, int accidentID, int memberID, String Description) {



        try {

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("EXEC AddPhoto @Source = ?,@accidentID = ?, @memberID = ?, @Description=? ", new String[]{"id"});

            ps.setString(1, source);
            ps.setInt(2, accidentID);
            ps.setInt(3, memberID);
                ps.setString(4, Description);

            ps.executeQuery();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}