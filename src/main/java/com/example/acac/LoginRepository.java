package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class LoginRepository {

    @Autowired
    public DataSource dataSource;




    public Member getMember(String eMail, String password) {
        Connection conn;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("Exec Login @eMail=?, @password=?");
            ps.setString(1, eMail);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                return new Member(resultSet.getInt("ID"),
                        resultSet.getString("personalNumber"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("city"),
                        resultSet.getString("address"),
                        resultSet.getString("zipCode"),
                        resultSet.getString("eMail"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("password"),
                        resultSet.getInt("Antal"));

            }
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
