package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    @Autowired MemberRepository memberRepository;

    @GetMapping ("/")
    public String getIndex(){
        return "index";
    }


    @PostMapping ("/")
    public String registerMember (@RequestParam int personalNumber,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String city,
                                  @RequestParam String address,
                                  @RequestParam int zipCode,
                                  @RequestParam String eMail,
                                  @RequestParam int phoneNumber,
                                  @RequestParam String regnr,
                                  @RequestParam String password) {

        System.out.println(firstName);
        System.out.println("heeej");
        return "LoggedIn";
    }


}
