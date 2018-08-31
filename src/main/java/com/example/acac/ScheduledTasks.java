package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
                String DriverFirstName1 = String.format("Förnamn förare: %s", accidentPair.get(0).getDriverFirstName());
                String DriverFirstName2 = String.format("Förnamn förare: %s", accidentPair.get(1).getDriverFirstName());

                LocalDate skadedag1 = accidentPair.get(0).getSkadedag();
                LocalDate skadedag2 = accidentPair.get(1).getSkadedag();

                String Driverlastname1 = String.format("name: %s", accidentPair.get(0).getDriverLastName());
                String Driverlastname2 = String.format("name: %s", accidentPair.get(1).getDriverLastName());

            String DriverPersonalID1 = String.format("name: %s", accidentPair.get(0).getDriverPersonalID());
            String DriverPersonalID2 = String.format("name: %s", accidentPair.get(1).getDriverPersonalID());

            String DriverPhoneNumber1= String.format("name: %s", accidentPair.get(0).getDriverPhoneNumber());
            String DriverPhoneNumber2 = String.format("name: %s", accidentPair.get(1).getDriverPhoneNumber());

            String Fösäkringsbolag1 = String.format("name: %s", accidentPair.get(0).getFörsäkringsbolag());
            String Fösäkringsbolag2 = String.format("name: %s", accidentPair.get(1).getFörsäkringsbolag());

            String Händelseförlopp1 = String.format("name: %s", accidentPair.get(0).getHändelseförlopp());
            String Händelseförlopp2 = String.format("name: %s", accidentPair.get(1).getHändelseförlopp());

            String Omständighet1 = String.format("name: %s", accidentPair.get(0).getOmständighet());
            String Omständighet2 = String.format("name: %s", accidentPair.get(1).getOmständighet());

            String PolisPåPlats1 = String.format("name: %s", accidentPair.get(0).getPolisPåPlats());
            String PolisPåPlats2 = String.format("name: %s", accidentPair.get(1).getPolisPåPlats());

            String Regnr1 = String.format("name: %s", accidentPair.get(0).getRegnr());
            String Regnr2 = String.format("name: %s", accidentPair.get(1).getRegnr());

            String Regnrmotpart1 = String.format("name: %s", accidentPair.get(0).getRegnrmotpart());
            String Regnrmotpart2 = String.format("name: %s", accidentPair.get(1).getRegnrmotpart());

            String Skadeplats1 = String.format("name: %s", accidentPair.get(0).getSkadeplats());
            String Skadeplats2 = String.format("name: %s", accidentPair.get(1).getSkadeplats());

            String Skadorpåbilen1 = String.format("name: %s", accidentPair.get(0).getSkadorPåBilen());
            String Skadorpåbilen2 = String.format("name: %s", accidentPair.get(1).getSkadorPåBilen());

            String Utandningsprov1 = String.format("name: %s", accidentPair.get(0).getUtandningsprov());
            String Utandningsprov2 = String.format("name: %s", accidentPair.get(1).getUtandningsprov());


            /*set matched where both regnr1 and regnr2 in database to skickat...*/
            accidentRepository.setSkickad(accidentPair.get(0).getRegnr(),accidentPair.get(1).getRegnr());

            System.out.println(skadedag1);
            System.out.println(Regnr1 + " " +Regnr2);
        }
        System.out.println("Sending mail...");
    }
}
