package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class MemberRepository {
    @Autowired
    public DataSource dataSource;


    public void addMember(int ID,
                          int personalNumber,
                          String firstName,
                          String lastName,
                          String city,
                          String address,
                          int zipCode,
                          String eMail,
                          int phoneNumber,
                          String password) {
        try {
            Connection conn = null;
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Member (personalNumber, " +
                    "firstName," +
                    "lastName," +
                    "city," +
                    "address," +
                    "zipCode," +
                    "eMail," +
                    "phoneNumber," +
                    "password) VALUES (?,?,?,?,?,?,?,?)", new String[]{"ID"});
            ps.setString(1, String.valueOf(personalNumber));
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, city);
            ps.setString(5, address);
            ps.setString(6, String.valueOf(zipCode));
            ps.setString(7, eMail);
            ps.setString(7, String.valueOf(phoneNumber));
            ps.setString(8, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

