package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping ("/addphoto")
    public String addphoto (@RequestParam int ID,
                            @RequestParam String source,
                            @RequestParam int accidentID) {
        photoRepository.addPhoto(ID, source, accidentID);
        return "home";
    }
}
