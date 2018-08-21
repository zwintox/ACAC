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

    private int userid;


    public boolean getMemeber(String eMail, String password) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Members WHERE eMail=? AND password=?");
            ps.setString(1, eMail);
            ps.setString(1, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                this.userid = resultSet.getInt("ID");
                return true;
            } else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
