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

    public String addNewAccident(Accident accident) {
        accidentRepository.addNewAccident(accident.getID(),
                accident.getRegnr(),
                accident.getFörsäkringsbolag(),
                accident.getOmständighet(),
                accident.getSkadedag(),
                accident.getSkadeplats(),
                accident.getDriverPersonalID(),
                accident.getDriverFirstName(),
                accident.getDriverLastName(),
                accident.getDriverPhoneNumber(),
                accident.getHändelseförlopp(),
                accident.getSkadorPåBilen(),
                accident.isPolisPåPlats(),
                accident.getUtandningsprov());

                return"confirmation";
    }
}
