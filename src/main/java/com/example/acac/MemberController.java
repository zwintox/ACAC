package com.example.acac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

    public String addMember(@Valid Member member, BindingResult bindingResult, Model model) throws MessagingException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "index";
        } else  {
            Encryption.encrypt(member.getPassword());
            boolean emailexist =
            mr.addMember(member.getPersonalNumber(),
                    member.getFirstName(),
                    member.getLastName(),
                    member.getCity(),
                    member.getAddress(),
                    Integer.parseInt(member.getZipCode()),
                    member.geteMail(),
                    member.getPhoneNumber(),
                    member.getPassword());
                    // Encryption.encrypt(member.getPassword()));
            model.addAttribute("error",false);
          
            if (emailexist == true){

                model.addAttribute("error", true);
                model.addAttribute("errormedelande", "Finns redan en användare med denna Email.");
            }


            Mail.generateRegistrationMessage(member.getFirstName(), member.geteMail());

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
        session.setAttribute("member", new Member(member.getID(), null, firstName, lastName, city, address, zipCode, eMail, phoneNumber, password));

        return "redirect:loggedIn";
    }


}
