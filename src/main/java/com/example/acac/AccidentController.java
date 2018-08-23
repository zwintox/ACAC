package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Date;

@Controller
public class AccidentController {
    @Autowired
    private AccidentRepository accidentRepository;


    @GetMapping("/addNewAccident")

    public String getNewAccident(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session !=null){
            return "loggedIn";
        }
        return "index";
    }

    @PostMapping("/addNewAccident")

    public String addNewAccident(@RequestParam String Regnr,
                                 @RequestParam String Försäkringsbolag,
                                 @RequestParam String Omständighet,
                                 @RequestParam Date Skadedag,
                                 @RequestParam String Skadeplats,
                                 @RequestParam String DriverPersonalID,
                                 @RequestParam String DriverFirstName,
                                 @RequestParam String DriverLastName,
                                 @RequestParam String DriverPhoneNumber,
                                 @RequestParam String Händelseförlopp,
                                 @RequestParam String SkadorPåBilen,
                                 @RequestParam boolean PolisPåPlats,
                                 @RequestParam String Utandningsprov,
                                 @RequestParam String regnrmotpart,
                                HttpServletRequest request,
                                Accident accident) {
        HttpSession session = request.getSession(false);
        if (session !=null){

            accidentRepository.addNewAccident(
                    Regnr,
                    Försäkringsbolag,
                    Omständighet,
                    Skadedag,
                    Skadeplats,
                    DriverPersonalID,
                    DriverFirstName,
                    DriverLastName,
                    DriverPhoneNumber,
                    Händelseförlopp,
                    SkadorPåBilen,
                    PolisPåPlats,
                    Utandningsprov,
                    regnrmotpart,
                    1);
            return "loggedIn";
        }
        return "index";
    }

}
