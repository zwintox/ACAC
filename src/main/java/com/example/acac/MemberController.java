package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @Autowired MemberRepository memberRepository;
    @Autowired
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
                                  @RequestParam String password       ) {
        mr.addMember(personalNumber,firstName,lastName,city,address,zipCode,eMail,phoneNumber,password);
        return "index";
    }
    @PostMapping ("/editMember")
    public String editMember (@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String city,
                              @RequestParam String address,
                              @RequestParam int zipCode,
                              @RequestParam String eMail,
                              @RequestParam String phoneNumber,
                              @RequestParam String password      ) {
        mr.editMember(firstName,lastName,city,address,zipCode,eMail,phoneNumber,password);
        return "LoggedIn";
    }


}
