package com.example.acac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.classreading.MethodMetadataReadingVisitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    LoginRepository lr;
    List<Member> members = new ArrayList<>();



    @GetMapping("/login")
    public String getIndex(Member member) {
        return "index";
    }


    @PostMapping("/login")
    public String login(@RequestParam String eMail,
                        @RequestParam String password,
                        HttpServletRequest request) throws NoSuchAlgorithmException {

        Member member = lr.getMember(eMail,Encryption.encrypt(password));
        if (member != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("member", member);
            members.add(member);
            return "redirect:loggedIn";
        } else {
            return "redirect:login";
        }
    }
    @GetMapping("/loggedIn")
    public String loggedIn(HttpServletRequest request, Accident accident, Model model) {
        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("FirstName",member.getFirstName());
        model.addAttribute("LastName",member.getLastName());
        model.addAttribute("eMail",member.geteMail());
        model.addAttribute("Address",member.getAddress());
        model.addAttribute("ZipCode",member.getZipCode());
        model.addAttribute("Password",member.getPassword());
        model.addAttribute("PhoneNumber",member.getPhoneNumber());
        model.addAttribute("City",member.getCity());
        model.addAttribute("Antal",member.getAntal());

        if (session != null) {
            return "loggedIn";
        }
        return "redirect:login";
    }

    @GetMapping("/LogOut")
    public String LogOut(HttpServletRequest request, Member member) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:login";
    }

    @GetMapping ("/change")
    public String change (Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("changeFirstName",member.getFirstName());
        model.addAttribute("changeLastName",member.getLastName());
        model.addAttribute("changeeMail",member.geteMail());
        model.addAttribute("changeAddress",member.getAddress());
        model.addAttribute("changeZipCode",member.getZipCode());
        model.addAttribute("changePassword",member.getPassword());
        model.addAttribute("changePhoneNumber",member.getPhoneNumber());
        model.addAttribute("changeCity",member.getCity());
        model.addAttribute("Antal",member.getAntal());
        return "profileInfo";
    }

    @GetMapping ("/formComplete")
    public String formComplete (Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("formCompleteFirstName",member.getFirstName());
        model.addAttribute("formCompleteLastName",member.getLastName());
        model.addAttribute("formCompleteeMail",member.geteMail());
        model.addAttribute("formCompleteAddress",member.getAddress());
        model.addAttribute("formCompleteZipCode",member.getZipCode());
        model.addAttribute("formCompletePassword",member.getPassword());
        model.addAttribute("formCompletePhoneNumber",member.getPhoneNumber());
        model.addAttribute("formCompleteCity",member.getCity());
        model.addAttribute("Antal",member.getAntal());
        return "formComplete";
    }

}