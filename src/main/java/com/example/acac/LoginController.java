
import org.springframework.beans.factory.annotation.Autowired;

package com.example.acac;


import org.springframework.stereotype.Controller;


@Controller
public class LoginController {

    @Autowired
    private MembersRepository membersRepository;



    @GetMapping("/login")
    public ModelAndView secret(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        List<Members> members = membersRepository.getLoggdeInMembers();
        if (session.getAttribute("loggedIn") != null) {

            return new ModelAndView("redirect:home").addObject("members",members);

        } else {

            return new ModelAndView("login");
        }
    }
    @PostMapping("/login")
    public String postForm(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpServletRequest request) {
        boolean member = membersRepository.getMember(username, password);
        if (member) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", true);

            return "redirect:home";

        } else {
            return "login";
        }

    }



}