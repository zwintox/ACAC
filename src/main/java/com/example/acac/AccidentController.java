package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.Date;

@Controller
public class AccidentController {
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/addNewAccident")

    public String addNewAccident(@RequestParam int ID,
                                 @RequestParam Date skadedag,
                                 @RequestParam String regnr,
                                 @RequestParam String försäkringsbolag,
                                 @RequestParam int driverPersonalID,
                                 @RequestParam String driverFirstName,
                                 @RequestParam String driverLastName,
                                 @RequestParam int driverPhoneNumber,
                                 @RequestParam String händelseförlopp,
                                 @RequestParam String skadorPåBilen) {
        accidentRepository.addNewAccident(ID,
                skadedag,
                regnr,
                försäkringsbolag,
                driverPersonalID,
                driverFirstName,
                driverLastName,
                driverPhoneNumber,
                händelseförlopp,
                skadorPåBilen);

                return"confirmation";
    }
}
