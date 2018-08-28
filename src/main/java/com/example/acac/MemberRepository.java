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
    public void addMember(String personalNumber,
                          String firstName,
                          String lastName,
                          String city,
                          String address,
                          int zipCode,
                          String eMail,
                          String phoneNumber,
                          String password) {
        try {

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("EXEC CreateUser @personalNumber = ?,@firstName = ?, @lastName = ?, @city = ?, @address = ?, @zipCode = ?,@eMail = ?, @phoneNumber = ?, @password = ?", new String[]{"id"});

            ps.setString(1, personalNumber);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, city);
            ps.setString(5, address);
            ps.setInt(6, (zipCode));
            ps.setString(7, eMail);
            ps.setString(8, phoneNumber);
            ps.setString(9, password);
            ps.executeQuery();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editMember (int ID,
                            String password,
                            String firstName,
                            String lastName,
                            String city,
                            String address,
                            int zipCode,
                            String eMail,
                            String phoneNumber) {
        try {
            conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("EXEC ChangeUser @ID = ? , @password = ?, @firstName = ?, @lastName = ?, @city = ?, @address = ?, @zipCode = ?,@eMail = ?, @phoneNumber = ?");
            ps.setInt(1, ID);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, city);
            ps.setString(6, address);
            ps.setInt(7, (zipCode));
            ps.setString(8, eMail);
            ps.setString(9, phoneNumber);

            ps.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
}

