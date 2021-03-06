package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AccidentController {
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private PhotoRepository photoRepository;


    @GetMapping("/addNewAccident")
    public String getNewAccident(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return "redirect:loggedIn";
        }
        return "redirect:login";
    }

    @PostMapping("/addNewAccident")
    public String addNewAccident(@Valid Accident accident, BindingResult bindingResult, @RequestParam(value = "name", defaultValue = "null", required = false) String[] names,
                                 @RequestParam(value = "file", defaultValue = "null", required = false) MultipartFile[] files, HttpServletRequest request, Model model) throws MessagingException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Member member = (Member) session.getAttribute("member");
            model.addAttribute("FirstName",member.getFirstName());
            model.addAttribute("LastName",member.getLastName());
            model.addAttribute("eMail",member.geteMail());
            model.addAttribute("Address",member.getAddress());
            model.addAttribute("ZipCode",member.getZipCode());
            model.addAttribute("Password",member.getPassword());
            model.addAttribute("PhoneNumber",member.getPhoneNumber());
            model.addAttribute("City",member.getCity());
            if(bindingResult.hasErrors()){
                return "loggedIn";
            }

                int accidentID = accidentRepository.addNewAccident(
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

            String source;

            if (files.length > 0) {

                for (int i = 0; i < files.length; i++) {
                    MultipartFile file = files[i];
                    String name = names[i];
                    try {
                        byte[] bytes = file.getBytes();

                        // Creating the directory to store file
                        String workingDir = System.getProperty("user.dir");

                        File dir = new File(workingDir + File.separator + "src" + File.separator + "main" + File.separator + "images" + File.separator + "tmpFiles" + File.separator + session.getId()+ File.separator + accidentID);
                        if (!dir.exists())
                            dir.mkdirs();

                        // Create the file on server
                        File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + i +file.getOriginalFilename());
                        BufferedOutputStream stream = new BufferedOutputStream(
                                new FileOutputStream(serverFile));
                        stream.write(bytes);
                        stream.close();

                     source = dir.getAbsolutePath();

                    } catch (Exception e) {
                        return "You failed to upload " + name + " => " + e.getMessage();
                    }
                    photoRepository.addPhoto(source, accidentID, member.getID(), name);
                }
            }
                Mail.generateClaimMessage(member.getFirstName(), member.geteMail());
                return "redirect:formComplete";
            } else {
            return "index";
        }
    }
}