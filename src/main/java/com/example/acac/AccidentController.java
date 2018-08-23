package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.Date;

@Controller
public class AccidentController {
    @Autowired
    private AccidentRepository accidentRepository;


    @PostMapping("/addNewAccident")

    public String addNewAccident(@Valid Accident accident, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println("funkar inte");
        }else {

            accidentRepository.addNewAccident(
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
                    accident.getPolisPåPlats(),
                    accident.getUtandningsprov(),
                    accident.getRegnrmotpart(),
                    1);
        }

        return "loggedIn";
    }
}
