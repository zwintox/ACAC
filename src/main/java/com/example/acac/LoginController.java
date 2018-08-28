package com.example.acac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.classreading.MethodMetadataReadingVisitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
                        HttpServletRequest request) {

        Member member = lr.getMember(eMail, password);
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
    public String loggedIn(HttpServletRequest request, Accident accident) {

        HttpSession session = request.getSession(false);
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
    public String change (Member member){
        return "profileInfo";
    }
}