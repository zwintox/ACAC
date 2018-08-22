package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @Autowired MemberRepository memberRepository;
    MemberRepository mr;
    List<Member> members = new ArrayList<>();

    @GetMapping ("/")
    public String getIndex(){
        return "index";
    }


    @PostMapping ("/")
    public String registerMember (@RequestParam String personalNumber,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String city,
                                  @RequestParam String address,
                                  @RequestParam int zipCode,
                                  @RequestParam String eMail,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String regnr,
                                  @RequestParam String password) {
        members.add(new member(mr.addMember(personalNumber,firstName,lastName,city,address,zipCode,eMail,phoneNumber,password)));
        System.out.println(firstName);
        System.out.println("heeej");
        return "LoggedIn";
    }


}
