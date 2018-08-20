package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    @Autowired MemberRepository memberRepository;


    @PostMapping ("/index")
    public String registerMember (@RequestParam int ID,
                                  @RequestParam int personalNumber,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String city,
                                  @RequestParam String address,
                                  @RequestParam int zipCode,
                                  @RequestParam String eMail,
                                  @RequestParam int phoneNumber,
                                  @RequestParam String password) {
        return "index";
    }
}
