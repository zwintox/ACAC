package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AccidentRepository {

    @Autowired
    public DataSource dataSource;
    
}

