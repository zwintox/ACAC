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


    public void addPhoto(int ID, String source, int accidentID) {

/*
                           {
        try {

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("EXEC CreateUser @personalNumber = ?,@firstName = ?, @lastName = ?", new String[]{"id"});

            ps.setString(1, personalNumber);
            ps.setString(2, firstName);
            ps.setString(3, lastName);

            ps.executeQuery();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

*/
    }
}