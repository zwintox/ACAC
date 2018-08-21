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

    Connection conn = null;
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
            ps.setInt(1, (personalNumber));
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, city);
            ps.setString(5, address);
            ps.setInt(6, (zipCode));
            ps.setString(7, eMail);
            ps.setInt(7, (phoneNumber));
            ps.setString(8, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

