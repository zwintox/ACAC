package com.example.acac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberRepository mr;
    List<Member> members = new ArrayList<>();

    @GetMapping("/")
    public String getIndex(Member member) {
        return "index";
    }


    @PostMapping("/")

    public String addMember(@Valid Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "index";
        } else {
            mr.addMember(member.getPersonalNumber(),
                    member.getFirstName(),
                    member.getLastName(),
                    member.getCity(),
                    member.getAddress(),
                    Integer.parseInt(member.getZipCode()),
                    member.geteMail(),
                    member.getPhoneNumber(),
                    member.getPassword());
            model.addAttribute("error",false);
            return "index";
        }
    }

    @PostMapping("/editMember")
    public String editMember(@RequestParam String password,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String city,
                             @RequestParam String address,
                             @RequestParam String zipCode,
                             @RequestParam String eMail,
                             @RequestParam String phoneNumber,

    HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute("member");
        mr.editMember(member.getID(), password, firstName, lastName, city, address, Integer.parseInt(zipCode), eMail, phoneNumber);
        return "redirect:loggedIn";
    }


}
