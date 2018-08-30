package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {
    @Autowired
    private AccidentRepository accidentRepository;

    @Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0 * * * *")
    public void sendMail() {
        List<List<Accident>> matchedAccidents = accidentRepository.getMatchedAccidents();

        for (List<Accident> accidentPair: matchedAccidents) {
            boolean sendToFirst = false;
            for(Accident accident : accidentPair) {
                accident.getDriverFirstName();
                accident.getDriverLastName();
                accident.getDriverPersonalID();
                accident.getDriverPhoneNumber();
                accident.getFörsäkringsbolag();
                accident.getHändelseförlopp();
                accident.getOmständighet();
                accident.getPolisPåPlats();
                accident.getRegnr();
                accident.getRegnrmotpart();
                accident.getSkadedag();
                accident.getSkadeplats();
                accident.getSkadorPåBilen();
                accident.getUtandningsprov();
                System.out.println(accident.getDriverFirstName());
            }
            /*set matched where both regnr1 and regnr2 in database to skickat...*/
        }
        System.out.println("Sending mail...");
    }
}
