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

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.Date;

@Controller
public class AccidentController {
    @Autowired
    private AccidentRepository accidentRepository;


    @GetMapping("/addNewAccident")

    public String getNewAccident(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return "loggedIn";
        }
        return "index";
    }

    @PostMapping("/addNewAccident")


    public String addNewAccident(@Valid Accident accident, BindingResult bindingResult, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Member member = (Member) session.getAttribute("member");
            if(bindingResult.hasErrors()){
                return "loggedIn";
            }
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
                        member.getID());
                return "redirect:loggedIn";

        } else {
            return "index";
        }
    }
}